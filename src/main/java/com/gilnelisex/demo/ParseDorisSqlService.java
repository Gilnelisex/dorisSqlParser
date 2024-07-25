package com.gilnelisex.demo;

import com.gilnelisex.demo.antlr4.DorisLexer;
import com.gilnelisex.demo.antlr4.DorisParser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
     * 获取ParseTree对应的数据库、表、字段、分区名称
     *
     * @param parseTree
     * @return
     */
    private String getFinalChildString(ParseTree parseTree) {

        if (parseTree.getChildCount() != 0) {
            return getFinalChildString(parseTree.getChild(0));
        }
        return parseTree.toString();
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
                                getFinalChildString(name.parts.get(1)), getFinalChildString(name.parts.get(0)));
                    } else {
                        tableDbMap.put(getFinalChildString(name.parts.get(0)), null);
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

            DorisParser.SupportedCreateStatementContext createContext = ((DorisParser.SupportedCreateStatementAliasContext) tree).supportedCreateStatement();

            String databaseName = null;
            String tableName = null;

            // 创建数据库
            if (createContext instanceof DorisParser.CreateDatabaseContext) {
                DorisParser.IdentifierContext dbname =
                        ((DorisParser.CreateDatabaseContext) createContext).dbName;
                databaseName = getFinalChildString(dbname);
            }

            // 创建表
            if (createContext instanceof DorisParser.CreateTableContext) {
                DorisParser.MultipartIdentifierContext name =
                        ((DorisParser.CreateTableContext) createContext).name;
                List<DorisParser.ErrorCapturingIdentifierContext> parts = name.parts;
                if (parts.size() == 2) {
                    databaseName = getFinalChildString(parts.get(0));
                    tableName = getFinalChildString(parts.get(1));
                } else {
                    tableName = getFinalChildString(parts.get(0));
                }
            }

            tableName = removeNameSymbol(tableName);
            databaseName = removeNameSymbol(databaseName);
        }

        // 解析drop操作
        if (tree instanceof DorisParser.SupportedDropStatementAliasContext) {

            DorisParser.SupportedDropStatementContext dropContext = ((DorisParser.SupportedDropStatementAliasContext) tree).supportedDropStatement();

            String databaseName = null;
            String tableName = null;

            // 删除数据库
            if (dropContext instanceof DorisParser.DropDatabaseContext) {
                DorisParser.IdentifierContext dbname =
                        ((DorisParser.DropDatabaseContext) dropContext).dbname;
                databaseName = getFinalChildString(dbname);
            }

            // 删除表
            if (dropContext instanceof DorisParser.DropTableContext) {
                DorisParser.MultipartIdentifierContext name =
                        ((DorisParser.DropTableContext) dropContext).name;
                List<DorisParser.ErrorCapturingIdentifierContext> parts = name.parts;
                if (parts.size() == 2) {
                    databaseName = getFinalChildString(parts.get(0));
                    tableName = getFinalChildString(parts.get(1));
                } else {
                    tableName = getFinalChildString(parts.get(0));
                }
            }

            tableName = removeNameSymbol(tableName);
            databaseName = removeNameSymbol(databaseName);
        }

        // 解析insert操作血缘
        if (tree instanceof DorisParser.SupportedDmlStatementAliasContext) {

            DorisParser.SupportedDmlStatementContext insertContext = ((DorisParser.SupportedDmlStatementAliasContext) tree).supportedDmlStatement();

            List<Map<String, String>> fromTables = new ArrayList<>();
            String toDatabaseName = null;
            String toTableName = null;

            if (insertContext instanceof DorisParser.InsertTableContext) {
                DorisParser.MultipartIdentifierContext tableName =
                        ((DorisParser.InsertTableContext) insertContext).tableName;
                List<DorisParser.ErrorCapturingIdentifierContext> parts = tableName.parts;
                if (parts.size() == 2) {
                    toDatabaseName = getFinalChildString(parts.get(0));
                    toTableName = getFinalChildString(parts.get(1));
                } else {
                    toTableName = getFinalChildString(parts.get(0));
                }

                DorisParser.QueryContext query =
                        (DorisParser.QueryContext) insertContext.getChild(insertContext.getChildCount() - 1);
                DorisParser.QueryTermContext queryTermContext = query.queryTerm();
                getFromTables(queryTermContext, fromTables);
                System.out.println(fromTables);
            }
        }

        // 解析alter操作
        if (tree instanceof DorisParser.SupportedAlterStatementAliasContext) {

            DorisParser.SupportedAlterStatementContext alterContext = ((DorisParser.SupportedAlterStatementAliasContext) tree).supportedAlterStatement();

            // rename database
            if(alterContext instanceof DorisParser.AlterDatabaseRenameContext) {

            }

            // rename table
            if(alterContext instanceof DorisParser.AlterTableRenameContext) {

            }

            // modify table comment
            if(alterContext instanceof DorisParser.AlterTableModifyTableCommentContext) {

            }

            // add column
            if(alterContext instanceof DorisParser.AlterTableAddColumnContext) {

            }

            // drop column
            if(alterContext instanceof DorisParser.AlterTableDropColumnContext) {

            }

            // modify column
            if(alterContext instanceof DorisParser.AlterTableModifyColumnContext) {

            }

            // modify column comment
            if(alterContext instanceof DorisParser.AlterTableModifyColumnCommentContext) {

            }

            // rename column
            if(alterContext instanceof DorisParser.AlterTableRenameColumnContext) {

            }

            // add partition
            if(alterContext instanceof DorisParser.AlterTableAddPartitionContext) {

            }

            // drop partition
            if(alterContext instanceof DorisParser.AlterTableDropPartitionContext) {

            }

            // modify partition
            if(alterContext instanceof DorisParser.AlterTableModifyPartitionContext) {

            }

            // rename partition
            if(alterContext instanceof DorisParser.AlterTableRenamePartitionContext) {

            }
        }
    }
}