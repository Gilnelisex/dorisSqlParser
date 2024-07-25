package com.gilnelisex.demo;

import com.gilnelisex.demo.antlr4.DorisLexer;
import com.gilnelisex.demo.antlr4.DorisParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ParseDorisSqlService {

    /**
     * 去除名称开头和结尾的`符号
     *
     * @param name
     * @return
     */
    private String removeNameSymbol(String name) {

        if (name == null || name.isEmpty()) {
            return name;
        }
        if (name.indexOf("`") == 0 && name.lastIndexOf("`") == name.length() - 1) {
            return name.substring(1, name.length() - 1);
        }
        return name;
    }

    /**
     * 获取MultipartIdentifierContext对应的数据库、表名称
     *
     * @param multipartIdentifierContext
     * @return
     */
    private Map<String, String> getFinalNameFromMultipartIdentifierContext(
            DorisParser.MultipartIdentifierContext multipartIdentifierContext) {

        Map<String, String> result = new HashMap<>();
        String databaseName = null;
        String tableName = null;
        List<DorisParser.ErrorCapturingIdentifierContext> parts = multipartIdentifierContext.parts;
        if (parts.size() == 2) {
            databaseName = parts.get(0).getText();
            tableName = parts.get(1).getText();
        } else {
            tableName = parts.get(0).getText();
        }
        result.put(removeNameSymbol(tableName), removeNameSymbol(databaseName));
        return result;
    }

    /**
     * 获取PartitionDefContext对应的所有分区名称
     *
     * @param partitionDefContext
     * @param partitionNames
     */
    private void getPartitionNames(
            DorisParser.PartitionDefContext partitionDefContext, List<String> partitionNames) {

        ParseTree child = partitionDefContext.getChild(0);
        if (child instanceof DorisParser.LessThanPartitionDefContext) {
            partitionNames.add(((DorisParser.LessThanPartitionDefContext) child).partitionName.getText());
        }
        if (child instanceof DorisParser.FixedPartitionDefContext) {
            partitionNames.add(((DorisParser.FixedPartitionDefContext) child).partitionName.getText());
        }
        if (child instanceof DorisParser.InPartitionDefContext) {
            partitionNames.add(((DorisParser.InPartitionDefContext) child).partitionName.getText());
        }
    }

    /**
     * RelationsContext中所有来源表信息
     *
     * @param relations
     * @param fromTables
     */
    private void getFromTables(
            DorisParser.RelationsContext relations, List<Map<String, String>> fromTables) {

        if (relations == null || fromTables == null) {
            return;
        }

        List<ParseTree> relationList = relations.children;
        for (ParseTree parseTree : relationList) {

            DorisParser.RelationContext relationContext = (DorisParser.RelationContext) parseTree;

            List<ParseTree> relationChildren = relationContext.children;

            for (ParseTree relationChild : relationChildren) {

                DorisParser.RelationPrimaryContext relationPrimaryContext;

                if (relationChildren.indexOf(relationChild) == 0) {
                    relationPrimaryContext = (DorisParser.RelationPrimaryContext) relationChild;
                } else {
                    DorisParser.JoinRelationContext joinRelationContext =
                            (DorisParser.JoinRelationContext) relationChild;
                    relationPrimaryContext = joinRelationContext.right;
                }

                if (relationPrimaryContext instanceof DorisParser.TableNameContext) {
                    DorisParser.MultipartIdentifierContext name =
                            (DorisParser.MultipartIdentifierContext) relationPrimaryContext.getChild(0);
                    Map<String, String> tableDbMap = new HashMap<>();
                    if (name.parts.size() == 2) {
                        tableDbMap.put(
                                removeNameSymbol(name.parts.get(1).getText()),
                                removeNameSymbol(name.parts.get(0).getText()));
                    } else {
                        tableDbMap.put(removeNameSymbol(name.parts.get(0).getText()), null);
                    }
                    fromTables.add(tableDbMap);
                }

                if (relationPrimaryContext instanceof DorisParser.AliasedQueryContext) {
                    DorisParser.AliasedQueryContext aliasedQueryContext =
                            (DorisParser.AliasedQueryContext) relationPrimaryContext;
                    getFromTables(aliasedQueryContext.query().queryTerm(), fromTables);
                }

                if (relationPrimaryContext instanceof DorisParser.RelationListContext) {
                    DorisParser.RelationListContext relationListContext =
                            (DorisParser.RelationListContext) relationPrimaryContext;
                    getFromTables(relationListContext.relations(), fromTables);
                }
            }
        }
    }

    /**
     * QueryTermContext中所有来源表信息
     *
     * @param queryTermContext
     * @param fromTables
     */
    private void getFromTables(
            DorisParser.QueryTermContext queryTermContext, List<Map<String, String>> fromTables) {

        if (queryTermContext == null || fromTables == null) {
            return;
        }

        if (queryTermContext instanceof DorisParser.SetOperationContext) {

            DorisParser.QueryTermContext left = ((DorisParser.SetOperationContext) queryTermContext).left;
            DorisParser.QueryTermContext right =
                    ((DorisParser.SetOperationContext) queryTermContext).right;
            getFromTables(left, fromTables);
            getFromTables(right, fromTables);
        }
        if (queryTermContext instanceof DorisParser.QueryTermDefaultContext) {

            DorisParser.QueryPrimaryContext queryPrimaryContext =
                    ((DorisParser.QueryTermDefaultContext) queryTermContext).queryPrimary();

            if (queryPrimaryContext instanceof DorisParser.QueryPrimaryDefaultContext) {

                ParseTree parseTree = queryPrimaryContext.getChild(0);
                DorisParser.QuerySpecificationContext querySpecificationContext =
                        (DorisParser.QuerySpecificationContext) parseTree;
                List<ParseTree> children = querySpecificationContext.children;
                for (ParseTree child : children) {
                    if (child instanceof DorisParser.FromClauseContext) {
                        getFromTables((DorisParser.RelationsContext) child.getChild(1), fromTables);
                    }
                }
            }
            if (queryPrimaryContext instanceof DorisParser.SubqueryContext) {

                DorisParser.SubqueryContext subqueryContext =
                        (DorisParser.SubqueryContext) queryPrimaryContext;
                getFromTables(subqueryContext.query().queryTerm(), fromTables);
            }
        }
    }

    public void parse(String sql) {

        ParseTree tree = null;

        try {
            CharStream inputStream = CharStreams.fromString(sql);
            DorisLexer lexer = new DorisLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            DorisParser parser = new DorisParser(tokenStream);
            tree = parser.statement().getChild(0);
        } catch (Exception e) {
            log.error("dorisSql解析失败: " + sql);
        }

        // 解析create操作
        if (tree instanceof DorisParser.SupportedCreateStatementAliasContext) {

            DorisParser.SupportedCreateStatementContext createContext =
                    ((DorisParser.SupportedCreateStatementAliasContext) tree).supportedCreateStatement();

            String databaseName = null;
            String tableName = null;

            // 创建数据库
            if (createContext instanceof DorisParser.CreateDatabaseContext) {
                databaseName = ((DorisParser.CreateDatabaseContext) createContext).dbName.getText();
            }

            // 创建表
            if (createContext instanceof DorisParser.CreateTableContext) {

                // 获取表名和库名
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(
                                ((DorisParser.CreateTableContext) createContext).name);
                tableName = (String) result.keySet().toArray()[0];
                databaseName = result.get(tableName);
            }

            tableName = removeNameSymbol(tableName);
            databaseName = removeNameSymbol(databaseName);
        }

        // 解析drop操作
        if (tree instanceof DorisParser.SupportedDropStatementAliasContext) {

            DorisParser.SupportedDropStatementContext dropContext =
                    ((DorisParser.SupportedDropStatementAliasContext) tree).supportedDropStatement();

            String databaseName = null;
            String tableName = null;

            // 删除数据库
            if (dropContext instanceof DorisParser.DropDatabaseContext) {
                databaseName = ((DorisParser.DropDatabaseContext) dropContext).dbname.getText();
            }

            // 删除表
            if (dropContext instanceof DorisParser.DropTableContext) {

                // 获取表名和库名
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(
                                ((DorisParser.DropTableContext) dropContext).name);
                tableName = (String) result.keySet().toArray()[0];
                databaseName = result.get(tableName);
            }

            tableName = removeNameSymbol(tableName);
            databaseName = removeNameSymbol(databaseName);
        }

        // 解析insert操作血缘
        if (tree instanceof DorisParser.SupportedDmlStatementAliasContext) {

            DorisParser.SupportedDmlStatementContext insertContext =
                    ((DorisParser.SupportedDmlStatementAliasContext) tree).supportedDmlStatement();

            List<Map<String, String>> fromTables = new ArrayList<>();
            String toDatabaseName = null;
            String toTableName = null;

            if (insertContext instanceof DorisParser.InsertTableContext) {

                // 获取表名和库名
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(
                                ((DorisParser.InsertTableContext) insertContext).tableName);
                toTableName = (String) result.keySet().toArray()[0];
                toDatabaseName = result.get(toTableName);

                DorisParser.QueryContext query =
                        (DorisParser.QueryContext) insertContext.getChild(insertContext.getChildCount() - 1);
                DorisParser.QueryTermContext queryTermContext = query.queryTerm();
                getFromTables(queryTermContext, fromTables);
                System.out.println(fromTables);
            }
        }

        // 解析alter操作
        if (tree instanceof DorisParser.SupportedAlterStatementAliasContext) {

            DorisParser.SupportedAlterStatementContext alterContext =
                    ((DorisParser.SupportedAlterStatementAliasContext) tree).supportedAlterStatement();

            // rename database
            if (alterContext instanceof DorisParser.AlterDatabaseRenameContext) {
                DorisParser.AlterDatabaseRenameContext databaseRenameContext =
                        (DorisParser.AlterDatabaseRenameContext) alterContext;
                String oldDatabaseName = removeNameSymbol(databaseRenameContext.oldDbName.getText());
                String newDatabaseName = removeNameSymbol(databaseRenameContext.newDbName.getText());
            }

            // rename table
            if (alterContext instanceof DorisParser.AlterTableRenameContext) {
                DorisParser.AlterTableRenameContext tableRenameContext =
                        (DorisParser.AlterTableRenameContext) alterContext;
                Map<String, String> oldResult =
                        getFinalNameFromMultipartIdentifierContext(tableRenameContext.oldTableName);
                Map<String, String> newResult =
                        getFinalNameFromMultipartIdentifierContext(tableRenameContext.newTableName);
            }

            // modify table comment
            if (alterContext instanceof DorisParser.AlterTableModifyTableCommentContext) {
                DorisParser.AlterTableModifyTableCommentContext modifyTableCommentContext =
                        (DorisParser.AlterTableModifyTableCommentContext) alterContext;
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(modifyTableCommentContext.name);
                Token commentToken = modifyTableCommentContext.comment;
                String comment = null;
                if (commentToken != null) {
                    comment = commentToken.getText();
                }
            }

            // add column
            if (alterContext instanceof DorisParser.AlterTableAddColumnContext) {
                DorisParser.AlterTableAddColumnContext addColumnContext =
                        (DorisParser.AlterTableAddColumnContext) alterContext;
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(addColumnContext.name);
                List<DorisParser.ColumnDefContext> cols = addColumnContext.columnDefs().cols;
                for (DorisParser.ColumnDefContext col : cols) {
                    String colName = col.colName.getText();
                    String type = col.type.getText();
                    Token commentToken = col.comment;
                    String comment = null;
                    if (commentToken != null) {
                        comment = commentToken.getText();
                    }
                }
            }

            // drop column
            if (alterContext instanceof DorisParser.AlterTableDropColumnContext) {
                DorisParser.AlterTableDropColumnContext dropColumnContext =
                        (DorisParser.AlterTableDropColumnContext) alterContext;
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(dropColumnContext.name);
                List<DorisParser.DropColumnDefContext> cols = dropColumnContext.dropColumn.cols;
                List<String> dropColumns = new ArrayList<>();
                for (DorisParser.DropColumnDefContext col : cols) {
                    dropColumns.add(col.colName.getText());
                }
            }

            // modify column
            if (alterContext instanceof DorisParser.AlterTableModifyColumnContext) {
                DorisParser.AlterTableModifyColumnContext modifyColumnContext =
                        (DorisParser.AlterTableModifyColumnContext) alterContext;
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(modifyColumnContext.name);
                List<DorisParser.ColumnDefContext> cols = modifyColumnContext.modifyColumn.cols;
                for (DorisParser.ColumnDefContext col : cols) {
                    String colName = col.colName.getText();
                    String type = col.type.getText();
                    Token commentToken = col.comment;
                    String comment = null;
                    if (commentToken != null) {
                        comment = commentToken.getText();
                    }
                }
            }

            // rename column
            if (alterContext instanceof DorisParser.AlterTableRenameColumnContext) {
                DorisParser.AlterTableRenameColumnContext renameColumnContext =
                        (DorisParser.AlterTableRenameColumnContext) alterContext;
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(renameColumnContext.name);
                String oldColName = renameColumnContext.oldColName.getText();
                String newColName = renameColumnContext.newColName.getText();
            }

            // add partition
            if (alterContext instanceof DorisParser.AlterTableAddPartitionContext) {
                DorisParser.AlterTableAddPartitionContext addPartitionContext =
                        (DorisParser.AlterTableAddPartitionContext) alterContext;
                List<DorisParser.AddPartitionDefContext> partitions =
                        addPartitionContext.addPartition.partitions;
                List<String> addPartitions = new ArrayList<>();
                for (DorisParser.AddPartitionDefContext partition : partitions) {
                    getPartitionNames(partition.partitionDef(), addPartitions);
                }
            }

            // drop partition
            if (alterContext instanceof DorisParser.AlterTableDropPartitionContext) {
                DorisParser.AlterTableDropPartitionContext dropPartitionContext =
                        (DorisParser.AlterTableDropPartitionContext) alterContext;
                List<DorisParser.DropPartitionDefContext> partitions =
                        dropPartitionContext.dropPartition.partitions;
                List<String> dropPartitions = new ArrayList<>();
                for (DorisParser.DropPartitionDefContext partition : partitions) {
                    getPartitionNames(partition.partitionDef(), dropPartitions);
                }
            }

            // rename partition
            if (alterContext instanceof DorisParser.AlterTableRenamePartitionContext) {
                DorisParser.AlterTableRenamePartitionContext renamePartitionContext =
                        (DorisParser.AlterTableRenamePartitionContext) alterContext;
                Map<String, String> result =
                        getFinalNameFromMultipartIdentifierContext(renamePartitionContext.name);
                String oldPartitionName = renamePartitionContext.oldPartitionName.getText();
                String newPartitionName = renamePartitionContext.newPartitionName.getText();
            }

            // modify partition
            if (alterContext instanceof DorisParser.AlterTableModifyPartitionContext) {
                // doNothing
            }
        }
    }
}
