// Generated from /Users/forzh/WorkPlace/demo/src/main/resources/antlr4/DorisParser.g4 by ANTLR
// 4.13.1
package com.gilnelisex.demo.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * DorisParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface DorisParserVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link DorisParser#multiStatements}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMultiStatements(DorisParser.MultiStatementsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#singleStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSingleStatement(DorisParser.SingleStatementContext ctx);
    /**
     * Visit a parse tree produced by the {@code statementBaseAlias} labeled alternative in {@link
     * DorisParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatementBaseAlias(DorisParser.StatementBaseAliasContext ctx);
    /**
     * Visit a parse tree produced by the {@code callProcedure} labeled alternative in {@link
     * DorisParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCallProcedure(DorisParser.CallProcedureContext ctx);
    /**
     * Visit a parse tree produced by the {@code createProcedure} labeled alternative in {@link
     * DorisParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateProcedure(DorisParser.CreateProcedureContext ctx);
    /**
     * Visit a parse tree produced by the {@code dropProcedure} labeled alternative in {@link
     * DorisParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropProcedure(DorisParser.DropProcedureContext ctx);
    /**
     * Visit a parse tree produced by the {@code showProcedureStatus} labeled alternative in {@link
     * DorisParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowProcedureStatus(DorisParser.ShowProcedureStatusContext ctx);
    /**
     * Visit a parse tree produced by the {@code showCreateProcedure} labeled alternative in {@link
     * DorisParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowCreateProcedure(DorisParser.ShowCreateProcedureContext ctx);
    /**
     * Visit a parse tree produced by the {@code statementDefault} labeled alternative in {@link
     * DorisParser#statementBase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatementDefault(DorisParser.StatementDefaultContext ctx);
    /**
     * Visit a parse tree produced by the {@code supportedDmlStatementAlias} labeled alternative in
     * {@link DorisParser#statementBase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSupportedDmlStatementAlias(DorisParser.SupportedDmlStatementAliasContext ctx);
    /**
     * Visit a parse tree produced by the {@code supportedCreateStatementAlias} labeled alternative in
     * {@link DorisParser#statementBase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSupportedCreateStatementAlias(DorisParser.SupportedCreateStatementAliasContext ctx);
    /**
     * Visit a parse tree produced by the {@code supportedAlterStatementAlias} labeled alternative in
     * {@link DorisParser#statementBase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSupportedAlterStatementAlias(DorisParser.SupportedAlterStatementAliasContext ctx);
    /**
     * Visit a parse tree produced by the {@code materailizedViewStatementAlias} labeled alternative
     * in {@link DorisParser#statementBase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMaterailizedViewStatementAlias(DorisParser.MaterailizedViewStatementAliasContext ctx);
    /**
     * Visit a parse tree produced by the {@code constraintStatementAlias} labeled alternative in
     * {@link DorisParser#statementBase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstraintStatementAlias(DorisParser.ConstraintStatementAliasContext ctx);
    /**
     * Visit a parse tree produced by the {@code supportedDropStatementAlias} labeled alternative in
     * {@link DorisParser#statementBase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSupportedDropStatementAlias(DorisParser.SupportedDropStatementAliasContext ctx);
    /**
     * Visit a parse tree produced by the {@code unsupported} labeled alternative in {@link
     * DorisParser#statementBase}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnsupported(DorisParser.UnsupportedContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#unsupportedStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnsupportedStatement(DorisParser.UnsupportedStatementContext ctx);
    /**
     * Visit a parse tree produced by the {@code createMTMV} labeled alternative in {@link
     * DorisParser#materailizedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateMTMV(DorisParser.CreateMTMVContext ctx);
    /**
     * Visit a parse tree produced by the {@code refreshMTMV} labeled alternative in {@link
     * DorisParser#materailizedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRefreshMTMV(DorisParser.RefreshMTMVContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterMTMV} labeled alternative in {@link
     * DorisParser#materailizedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterMTMV(DorisParser.AlterMTMVContext ctx);
    /**
     * Visit a parse tree produced by the {@code dropMTMV} labeled alternative in {@link
     * DorisParser#materailizedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropMTMV(DorisParser.DropMTMVContext ctx);
    /**
     * Visit a parse tree produced by the {@code pauseMTMV} labeled alternative in {@link
     * DorisParser#materailizedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPauseMTMV(DorisParser.PauseMTMVContext ctx);
    /**
     * Visit a parse tree produced by the {@code resumeMTMV} labeled alternative in {@link
     * DorisParser#materailizedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitResumeMTMV(DorisParser.ResumeMTMVContext ctx);
    /**
     * Visit a parse tree produced by the {@code cancelMTMVTask} labeled alternative in {@link
     * DorisParser#materailizedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCancelMTMVTask(DorisParser.CancelMTMVTaskContext ctx);
    /**
     * Visit a parse tree produced by the {@code showCreateMTMV} labeled alternative in {@link
     * DorisParser#materailizedViewStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowCreateMTMV(DorisParser.ShowCreateMTMVContext ctx);
    /**
     * Visit a parse tree produced by the {@code addConstraint} labeled alternative in {@link
     * DorisParser#constraintStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddConstraint(DorisParser.AddConstraintContext ctx);
    /**
     * Visit a parse tree produced by the {@code dropConstraint} labeled alternative in {@link
     * DorisParser#constraintStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropConstraint(DorisParser.DropConstraintContext ctx);
    /**
     * Visit a parse tree produced by the {@code showConstraint} labeled alternative in {@link
     * DorisParser#constraintStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShowConstraint(DorisParser.ShowConstraintContext ctx);
    /**
     * Visit a parse tree produced by the {@code insertTable} labeled alternative in {@link
     * DorisParser#supportedDmlStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsertTable(DorisParser.InsertTableContext ctx);
    /**
     * Visit a parse tree produced by the {@code update} labeled alternative in {@link
     * DorisParser#supportedDmlStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdate(DorisParser.UpdateContext ctx);
    /**
     * Visit a parse tree produced by the {@code delete} labeled alternative in {@link
     * DorisParser#supportedDmlStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDelete(DorisParser.DeleteContext ctx);
    /**
     * Visit a parse tree produced by the {@code load} labeled alternative in {@link
     * DorisParser#supportedDmlStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLoad(DorisParser.LoadContext ctx);
    /**
     * Visit a parse tree produced by the {@code mysqlLoad} labeled alternative in {@link
     * DorisParser#supportedDmlStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMysqlLoad(DorisParser.MysqlLoadContext ctx);
    /**
     * Visit a parse tree produced by the {@code export} labeled alternative in {@link
     * DorisParser#supportedDmlStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExport(DorisParser.ExportContext ctx);
    /**
     * Visit a parse tree produced by the {@code createTable} labeled alternative in {@link
     * DorisParser#supportedCreateStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateTable(DorisParser.CreateTableContext ctx);
    /**
     * Visit a parse tree produced by the {@code createView} labeled alternative in {@link
     * DorisParser#supportedCreateStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateView(DorisParser.CreateViewContext ctx);
    /**
     * Visit a parse tree produced by the {@code createTableLike} labeled alternative in {@link
     * DorisParser#supportedCreateStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateTableLike(DorisParser.CreateTableLikeContext ctx);
    /**
     * Visit a parse tree produced by the {@code createRowPolicy} labeled alternative in {@link
     * DorisParser#supportedCreateStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateRowPolicy(DorisParser.CreateRowPolicyContext ctx);
    /**
     * Visit a parse tree produced by the {@code createDatabase} labeled alternative in {@link
     * DorisParser#supportedCreateStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreateDatabase(DorisParser.CreateDatabaseContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterView} labeled alternative in {@link
     * DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterView(DorisParser.AlterViewContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterDatabaseRename} labeled alternative in {@link
     * DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterDatabaseRename(DorisParser.AlterDatabaseRenameContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableRename} labeled alternative in {@link
     * DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableRename(DorisParser.AlterTableRenameContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableModifyTableComment} labeled alternative in
     * {@link DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableModifyTableComment(DorisParser.AlterTableModifyTableCommentContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableAddColumn} labeled alternative in {@link
     * DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableAddColumn(DorisParser.AlterTableAddColumnContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableDropColumn} labeled alternative in {@link
     * DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableDropColumn(DorisParser.AlterTableDropColumnContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableModifyColumn} labeled alternative in {@link
     * DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableModifyColumn(DorisParser.AlterTableModifyColumnContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableRenameColumn} labeled alternative in {@link
     * DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableRenameColumn(DorisParser.AlterTableRenameColumnContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableAddPartition} labeled alternative in {@link
     * DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableAddPartition(DorisParser.AlterTableAddPartitionContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableDropPartition} labeled alternative in
     * {@link DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableDropPartition(DorisParser.AlterTableDropPartitionContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableModifyPartition} labeled alternative in
     * {@link DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableModifyPartition(DorisParser.AlterTableModifyPartitionContext ctx);
    /**
     * Visit a parse tree produced by the {@code alterTableRenamePartition} labeled alternative in
     * {@link DorisParser#supportedAlterStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAlterTableRenamePartition(DorisParser.AlterTableRenamePartitionContext ctx);
    /**
     * Visit a parse tree produced by the {@code dropCatalogRecycleBin} labeled alternative in {@link
     * DorisParser#supportedDropStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropCatalogRecycleBin(DorisParser.DropCatalogRecycleBinContext ctx);
    /**
     * Visit a parse tree produced by the {@code dropTable} labeled alternative in {@link
     * DorisParser#supportedDropStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropTable(DorisParser.DropTableContext ctx);
    /**
     * Visit a parse tree produced by the {@code dropDatabase} labeled alternative in {@link
     * DorisParser#supportedDropStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropDatabase(DorisParser.DropDatabaseContext ctx);
    /**
     * Visit a parse tree produced by the {@code setDefaultStorageVault} labeled alternative in {@link
     * DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetDefaultStorageVault(DorisParser.SetDefaultStorageVaultContext ctx);
    /**
     * Visit a parse tree produced by the {@code setUserProperties} labeled alternative in {@link
     * DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetUserProperties(DorisParser.SetUserPropertiesContext ctx);
    /**
     * Visit a parse tree produced by the {@code setSystemVariableWithType} labeled alternative in
     * {@link DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetSystemVariableWithType(DorisParser.SetSystemVariableWithTypeContext ctx);
    /**
     * Visit a parse tree produced by the {@code setSystemVariableWithoutType} labeled alternative in
     * {@link DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetSystemVariableWithoutType(DorisParser.SetSystemVariableWithoutTypeContext ctx);
    /**
     * Visit a parse tree produced by the {@code setCharset} labeled alternative in {@link
     * DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetCharset(DorisParser.SetCharsetContext ctx);
    /**
     * Visit a parse tree produced by the {@code setNames} labeled alternative in {@link
     * DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetNames(DorisParser.SetNamesContext ctx);
    /**
     * Visit a parse tree produced by the {@code setTransaction} labeled alternative in {@link
     * DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetTransaction(DorisParser.SetTransactionContext ctx);
    /**
     * Visit a parse tree produced by the {@code setCollate} labeled alternative in {@link
     * DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetCollate(DorisParser.SetCollateContext ctx);
    /**
     * Visit a parse tree produced by the {@code setPassword} labeled alternative in {@link
     * DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetPassword(DorisParser.SetPasswordContext ctx);
    /**
     * Visit a parse tree produced by the {@code setLdapAdminPassword} labeled alternative in {@link
     * DorisParser#unsupportedSetStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetLdapAdminPassword(DorisParser.SetLdapAdminPasswordContext ctx);
    /**
     * Visit a parse tree produced by the {@code useDatabase} labeled alternative in {@link
     * DorisParser#unsupportedUseStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUseDatabase(DorisParser.UseDatabaseContext ctx);
    /**
     * Visit a parse tree produced by the {@code useCloudCluster} labeled alternative in {@link
     * DorisParser#unsupportedUseStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUseCloudCluster(DorisParser.UseCloudClusterContext ctx);
    /**
     * Visit a parse tree produced by the {@code setSystemVariable} labeled alternative in {@link
     * DorisParser#variable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetSystemVariable(DorisParser.SetSystemVariableContext ctx);
    /**
     * Visit a parse tree produced by the {@code setUserVariable} labeled alternative in {@link
     * DorisParser#variable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetUserVariable(DorisParser.SetUserVariableContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#transactionAccessMode}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTransactionAccessMode(DorisParser.TransactionAccessModeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#isolationLevel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIsolationLevel(DorisParser.IsolationLevelContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#constraint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstraint(DorisParser.ConstraintContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#partitionSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPartitionSpec(DorisParser.PartitionSpecContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#partitionTable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPartitionTable(DorisParser.PartitionTableContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#identityOrFunctionList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentityOrFunctionList(DorisParser.IdentityOrFunctionListContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#identityOrFunction}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentityOrFunction(DorisParser.IdentityOrFunctionContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#dataDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDataDesc(DorisParser.DataDescContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#buildMode}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBuildMode(DorisParser.BuildModeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#refreshTrigger}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRefreshTrigger(DorisParser.RefreshTriggerContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#refreshSchedule}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRefreshSchedule(DorisParser.RefreshScheduleContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#refreshMethod}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRefreshMethod(DorisParser.RefreshMethodContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#mvPartition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMvPartition(DorisParser.MvPartitionContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#identifierOrStringLiteral}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifierOrStringLiteral(DorisParser.IdentifierOrStringLiteralContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#identifierOrText}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifierOrText(DorisParser.IdentifierOrTextContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#userIdentify}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUserIdentify(DorisParser.UserIdentifyContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#explain}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExplain(DorisParser.ExplainContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#planType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPlanType(DorisParser.PlanTypeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#mergeType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMergeType(DorisParser.MergeTypeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#preFilterClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPreFilterClause(DorisParser.PreFilterClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#deleteOnClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeleteOnClause(DorisParser.DeleteOnClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#sequenceColClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSequenceColClause(DorisParser.SequenceColClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#colFromPath}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColFromPath(DorisParser.ColFromPathContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#colMappingList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColMappingList(DorisParser.ColMappingListContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#mappingExpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMappingExpr(DorisParser.MappingExprContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#withRemoteStorageSystem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWithRemoteStorageSystem(DorisParser.WithRemoteStorageSystemContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#resourceDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitResourceDesc(DorisParser.ResourceDescContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#mysqlDataDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMysqlDataDesc(DorisParser.MysqlDataDescContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#skipLines}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSkipLines(DorisParser.SkipLinesContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#outFileClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOutFileClause(DorisParser.OutFileClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#query}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQuery(DorisParser.QueryContext ctx);
    /**
     * Visit a parse tree produced by the {@code queryTermDefault} labeled alternative in {@link
     * DorisParser#queryTerm}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQueryTermDefault(DorisParser.QueryTermDefaultContext ctx);
    /**
     * Visit a parse tree produced by the {@code setOperation} labeled alternative in {@link
     * DorisParser#queryTerm}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetOperation(DorisParser.SetOperationContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#setQuantifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSetQuantifier(DorisParser.SetQuantifierContext ctx);
    /**
     * Visit a parse tree produced by the {@code queryPrimaryDefault} labeled alternative in {@link
     * DorisParser#queryPrimary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQueryPrimaryDefault(DorisParser.QueryPrimaryDefaultContext ctx);
    /**
     * Visit a parse tree produced by the {@code subquery} labeled alternative in {@link
     * DorisParser#queryPrimary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSubquery(DorisParser.SubqueryContext ctx);
    /**
     * Visit a parse tree produced by the {@code valuesTable} labeled alternative in {@link
     * DorisParser#queryPrimary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitValuesTable(DorisParser.ValuesTableContext ctx);
    /**
     * Visit a parse tree produced by the {@code regularQuerySpecification} labeled alternative in
     * {@link DorisParser#querySpecification}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRegularQuerySpecification(DorisParser.RegularQuerySpecificationContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#cte}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCte(DorisParser.CteContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#aliasQuery}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAliasQuery(DorisParser.AliasQueryContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#columnAliases}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColumnAliases(DorisParser.ColumnAliasesContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#selectClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectClause(DorisParser.SelectClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#selectColumnClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectColumnClause(DorisParser.SelectColumnClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#whereClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhereClause(DorisParser.WhereClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#fromClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFromClause(DorisParser.FromClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#intoClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntoClause(DorisParser.IntoClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#bulkCollectClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBulkCollectClause(DorisParser.BulkCollectClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#tableRow}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTableRow(DorisParser.TableRowContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#relations}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRelations(DorisParser.RelationsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#relation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRelation(DorisParser.RelationContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#joinRelation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitJoinRelation(DorisParser.JoinRelationContext ctx);
    /**
     * Visit a parse tree produced by the {@code bracketDistributeType} labeled alternative in {@link
     * DorisParser#distributeType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBracketDistributeType(DorisParser.BracketDistributeTypeContext ctx);
    /**
     * Visit a parse tree produced by the {@code commentDistributeType} labeled alternative in {@link
     * DorisParser#distributeType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCommentDistributeType(DorisParser.CommentDistributeTypeContext ctx);
    /**
     * Visit a parse tree produced by the {@code bracketRelationHint} labeled alternative in {@link
     * DorisParser#relationHint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBracketRelationHint(DorisParser.BracketRelationHintContext ctx);
    /**
     * Visit a parse tree produced by the {@code commentRelationHint} labeled alternative in {@link
     * DorisParser#relationHint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCommentRelationHint(DorisParser.CommentRelationHintContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#aggClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAggClause(DorisParser.AggClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#groupingElement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGroupingElement(DorisParser.GroupingElementContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#groupingSet}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGroupingSet(DorisParser.GroupingSetContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#havingClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitHavingClause(DorisParser.HavingClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#selectHint}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelectHint(DorisParser.SelectHintContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#hintStatement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitHintStatement(DorisParser.HintStatementContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#hintAssignment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitHintAssignment(DorisParser.HintAssignmentContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#updateAssignment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateAssignment(DorisParser.UpdateAssignmentContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#updateAssignmentSeq}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdateAssignmentSeq(DorisParser.UpdateAssignmentSeqContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#lateralView}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLateralView(DorisParser.LateralViewContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#queryOrganization}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQueryOrganization(DorisParser.QueryOrganizationContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#sortClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSortClause(DorisParser.SortClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#sortItem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSortItem(DorisParser.SortItemContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#limitClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLimitClause(DorisParser.LimitClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#partitionClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPartitionClause(DorisParser.PartitionClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#joinType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitJoinType(DorisParser.JoinTypeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#joinCriteria}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitJoinCriteria(DorisParser.JoinCriteriaContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#identifierList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifierList(DorisParser.IdentifierListContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#identifierSeq}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifierSeq(DorisParser.IdentifierSeqContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#optScanParams}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOptScanParams(DorisParser.OptScanParamsContext ctx);
    /**
     * Visit a parse tree produced by the {@code tableName} labeled alternative in {@link
     * DorisParser#relationPrimary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTableName(DorisParser.TableNameContext ctx);
    /**
     * Visit a parse tree produced by the {@code aliasedQuery} labeled alternative in {@link
     * DorisParser#relationPrimary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAliasedQuery(DorisParser.AliasedQueryContext ctx);
    /**
     * Visit a parse tree produced by the {@code tableValuedFunction} labeled alternative in {@link
     * DorisParser#relationPrimary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTableValuedFunction(DorisParser.TableValuedFunctionContext ctx);
    /**
     * Visit a parse tree produced by the {@code relationList} labeled alternative in {@link
     * DorisParser#relationPrimary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRelationList(DorisParser.RelationListContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#materializedViewName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMaterializedViewName(DorisParser.MaterializedViewNameContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#propertyClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPropertyClause(DorisParser.PropertyClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#propertyItemList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPropertyItemList(DorisParser.PropertyItemListContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#propertyItem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPropertyItem(DorisParser.PropertyItemContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#propertyKey}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPropertyKey(DorisParser.PropertyKeyContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#propertyValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPropertyValue(DorisParser.PropertyValueContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#tableAlias}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTableAlias(DorisParser.TableAliasContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#multipartIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMultipartIdentifier(DorisParser.MultipartIdentifierContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#simpleColumnDefs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSimpleColumnDefs(DorisParser.SimpleColumnDefsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#simpleColumnDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSimpleColumnDef(DorisParser.SimpleColumnDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#columnDefs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColumnDefs(DorisParser.ColumnDefsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#dropColumnDefs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropColumnDefs(DorisParser.DropColumnDefsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#columnDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColumnDef(DorisParser.ColumnDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#dropColumnDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropColumnDef(DorisParser.DropColumnDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#indexDefs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIndexDefs(DorisParser.IndexDefsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#indexDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIndexDef(DorisParser.IndexDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#partitionsDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPartitionsDef(DorisParser.PartitionsDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#addPartitionsDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddPartitionsDef(DorisParser.AddPartitionsDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#dropPartitionsDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropPartitionsDef(DorisParser.DropPartitionsDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#addPartitionDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddPartitionDef(DorisParser.AddPartitionDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#dropPartitionDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDropPartitionDef(DorisParser.DropPartitionDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#partitionDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPartitionDef(DorisParser.PartitionDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#lessThanPartitionDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLessThanPartitionDef(DorisParser.LessThanPartitionDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#fixedPartitionDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFixedPartitionDef(DorisParser.FixedPartitionDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#stepPartitionDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStepPartitionDef(DorisParser.StepPartitionDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#inPartitionDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInPartitionDef(DorisParser.InPartitionDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#constantSeq}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstantSeq(DorisParser.ConstantSeqContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#partitionValueDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPartitionValueDef(DorisParser.PartitionValueDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#rollupDefs}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRollupDefs(DorisParser.RollupDefsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#rollupDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRollupDef(DorisParser.RollupDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#aggTypeDef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAggTypeDef(DorisParser.AggTypeDefContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#tabletList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTabletList(DorisParser.TabletListContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#inlineTable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInlineTable(DorisParser.InlineTableContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#namedExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNamedExpression(DorisParser.NamedExpressionContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#namedExpressionSeq}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNamedExpressionSeq(DorisParser.NamedExpressionSeqContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(DorisParser.ExpressionContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#lambdaExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLambdaExpression(DorisParser.LambdaExpressionContext ctx);
    /**
     * Visit a parse tree produced by the {@code exist} labeled alternative in {@link
     * DorisParser#booleanExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExist(DorisParser.ExistContext ctx);
    /**
     * Visit a parse tree produced by the {@code logicalNot} labeled alternative in {@link
     * DorisParser#booleanExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicalNot(DorisParser.LogicalNotContext ctx);
    /**
     * Visit a parse tree produced by the {@code predicated} labeled alternative in {@link
     * DorisParser#booleanExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPredicated(DorisParser.PredicatedContext ctx);
    /**
     * Visit a parse tree produced by the {@code isnull} labeled alternative in {@link
     * DorisParser#booleanExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIsnull(DorisParser.IsnullContext ctx);
    /**
     * Visit a parse tree produced by the {@code is_not_null_pred} labeled alternative in {@link
     * DorisParser#booleanExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIs_not_null_pred(DorisParser.Is_not_null_predContext ctx);
    /**
     * Visit a parse tree produced by the {@code logicalBinary} labeled alternative in {@link
     * DorisParser#booleanExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicalBinary(DorisParser.LogicalBinaryContext ctx);
    /**
     * Visit a parse tree produced by the {@code doublePipes} labeled alternative in {@link
     * DorisParser#booleanExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDoublePipes(DorisParser.DoublePipesContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#rowConstructor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRowConstructor(DorisParser.RowConstructorContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#rowConstructorItem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRowConstructorItem(DorisParser.RowConstructorItemContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#predicate}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPredicate(DorisParser.PredicateContext ctx);
    /**
     * Visit a parse tree produced by the {@code valueExpressionDefault} labeled alternative in {@link
     * DorisParser#valueExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitValueExpressionDefault(DorisParser.ValueExpressionDefaultContext ctx);
    /**
     * Visit a parse tree produced by the {@code comparison} labeled alternative in {@link
     * DorisParser#valueExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComparison(DorisParser.ComparisonContext ctx);
    /**
     * Visit a parse tree produced by the {@code bitOperation} labeled alternative in {@link
     * DorisParser#valueExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBitOperation(DorisParser.BitOperationContext ctx);
    /**
     * Visit a parse tree produced by the {@code arithmeticBinary} labeled alternative in {@link
     * DorisParser#valueExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArithmeticBinary(DorisParser.ArithmeticBinaryContext ctx);
    /**
     * Visit a parse tree produced by the {@code arithmeticUnary} labeled alternative in {@link
     * DorisParser#valueExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArithmeticUnary(DorisParser.ArithmeticUnaryContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#datetimeUnit}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDatetimeUnit(DorisParser.DatetimeUnitContext ctx);
    /**
     * Visit a parse tree produced by the {@code dateCeil} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDateCeil(DorisParser.DateCeilContext ctx);
    /**
     * Visit a parse tree produced by the {@code dereference} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDereference(DorisParser.DereferenceContext ctx);
    /**
     * Visit a parse tree produced by the {@code currentDate} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCurrentDate(DorisParser.CurrentDateContext ctx);
    /**
     * Visit a parse tree produced by the {@code timestampadd} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTimestampadd(DorisParser.TimestampaddContext ctx);
    /**
     * Visit a parse tree produced by the {@code date_sub} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDate_sub(DorisParser.Date_subContext ctx);
    /**
     * Visit a parse tree produced by the {@code cast} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCast(DorisParser.CastContext ctx);
    /**
     * Visit a parse tree produced by the {@code parenthesizedExpression} labeled alternative in
     * {@link DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParenthesizedExpression(DorisParser.ParenthesizedExpressionContext ctx);
    /**
     * Visit a parse tree produced by the {@code userVariable} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUserVariable(DorisParser.UserVariableContext ctx);
    /**
     * Visit a parse tree produced by the {@code elementAt} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitElementAt(DorisParser.ElementAtContext ctx);
    /**
     * Visit a parse tree produced by the {@code localTimestamp} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLocalTimestamp(DorisParser.LocalTimestampContext ctx);
    /**
     * Visit a parse tree produced by the {@code charFunction} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCharFunction(DorisParser.CharFunctionContext ctx);
    /**
     * Visit a parse tree produced by the {@code intervalLiteral} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntervalLiteral(DorisParser.IntervalLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code arrayRange} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArrayRange(DorisParser.ArrayRangeContext ctx);
    /**
     * Visit a parse tree produced by the {@code simpleCase} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSimpleCase(DorisParser.SimpleCaseContext ctx);
    /**
     * Visit a parse tree produced by the {@code columnReference} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColumnReference(DorisParser.ColumnReferenceContext ctx);
    /**
     * Visit a parse tree produced by the {@code star} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStar(DorisParser.StarContext ctx);
    /**
     * Visit a parse tree produced by the {@code convertType} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConvertType(DorisParser.ConvertTypeContext ctx);
    /**
     * Visit a parse tree produced by the {@code timestampdiff} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTimestampdiff(DorisParser.TimestampdiffContext ctx);
    /**
     * Visit a parse tree produced by the {@code convertCharSet} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConvertCharSet(DorisParser.ConvertCharSetContext ctx);
    /**
     * Visit a parse tree produced by the {@code subqueryExpression} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSubqueryExpression(DorisParser.SubqueryExpressionContext ctx);
    /**
     * Visit a parse tree produced by the {@code encryptKey} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEncryptKey(DorisParser.EncryptKeyContext ctx);
    /**
     * Visit a parse tree produced by the {@code date_add} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDate_add(DorisParser.Date_addContext ctx);
    /**
     * Visit a parse tree produced by the {@code currentTime} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCurrentTime(DorisParser.CurrentTimeContext ctx);
    /**
     * Visit a parse tree produced by the {@code localTime} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLocalTime(DorisParser.LocalTimeContext ctx);
    /**
     * Visit a parse tree produced by the {@code systemVariable} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSystemVariable(DorisParser.SystemVariableContext ctx);
    /**
     * Visit a parse tree produced by the {@code collate} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCollate(DorisParser.CollateContext ctx);
    /**
     * Visit a parse tree produced by the {@code currentUser} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCurrentUser(DorisParser.CurrentUserContext ctx);
    /**
     * Visit a parse tree produced by the {@code constantDefault} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstantDefault(DorisParser.ConstantDefaultContext ctx);
    /**
     * Visit a parse tree produced by the {@code extract} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExtract(DorisParser.ExtractContext ctx);
    /**
     * Visit a parse tree produced by the {@code currentTimestamp} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCurrentTimestamp(DorisParser.CurrentTimestampContext ctx);
    /**
     * Visit a parse tree produced by the {@code functionCall} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionCall(DorisParser.FunctionCallContext ctx);
    /**
     * Visit a parse tree produced by the {@code arraySlice} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArraySlice(DorisParser.ArraySliceContext ctx);
    /**
     * Visit a parse tree produced by the {@code dateFloor} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDateFloor(DorisParser.DateFloorContext ctx);
    /**
     * Visit a parse tree produced by the {@code searchedCase} labeled alternative in {@link
     * DorisParser#primaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSearchedCase(DorisParser.SearchedCaseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#castDataType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCastDataType(DorisParser.CastDataTypeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#functionCallExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionCallExpression(DorisParser.FunctionCallExpressionContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#functionIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionIdentifier(DorisParser.FunctionIdentifierContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#functionNameIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionNameIdentifier(DorisParser.FunctionNameIdentifierContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#windowSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWindowSpec(DorisParser.WindowSpecContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#windowFrame}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWindowFrame(DorisParser.WindowFrameContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#frameUnits}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFrameUnits(DorisParser.FrameUnitsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#frameBoundary}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFrameBoundary(DorisParser.FrameBoundaryContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#qualifiedName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQualifiedName(DorisParser.QualifiedNameContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#specifiedPartition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSpecifiedPartition(DorisParser.SpecifiedPartitionContext ctx);
    /**
     * Visit a parse tree produced by the {@code nullLiteral} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNullLiteral(DorisParser.NullLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code typeConstructor} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTypeConstructor(DorisParser.TypeConstructorContext ctx);
    /**
     * Visit a parse tree produced by the {@code numericLiteral} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericLiteral(DorisParser.NumericLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code booleanLiteral} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanLiteral(DorisParser.BooleanLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code stringLiteral} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStringLiteral(DorisParser.StringLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code arrayLiteral} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArrayLiteral(DorisParser.ArrayLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code mapLiteral} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMapLiteral(DorisParser.MapLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code structLiteral} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStructLiteral(DorisParser.StructLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code placeholder} labeled alternative in {@link
     * DorisParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPlaceholder(DorisParser.PlaceholderContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#comparisonOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComparisonOperator(DorisParser.ComparisonOperatorContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#booleanValue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanValue(DorisParser.BooleanValueContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#whenClause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhenClause(DorisParser.WhenClauseContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#interval}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInterval(DorisParser.IntervalContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#unitIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnitIdentifier(DorisParser.UnitIdentifierContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#dataTypeWithNullable}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDataTypeWithNullable(DorisParser.DataTypeWithNullableContext ctx);
    /**
     * Visit a parse tree produced by the {@code complexDataType} labeled alternative in {@link
     * DorisParser#dataType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComplexDataType(DorisParser.ComplexDataTypeContext ctx);
    /**
     * Visit a parse tree produced by the {@code aggStateDataType} labeled alternative in {@link
     * DorisParser#dataType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAggStateDataType(DorisParser.AggStateDataTypeContext ctx);
    /**
     * Visit a parse tree produced by the {@code primitiveDataType} labeled alternative in {@link
     * DorisParser#dataType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPrimitiveDataType(DorisParser.PrimitiveDataTypeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#primitiveColType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPrimitiveColType(DorisParser.PrimitiveColTypeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#complexColTypeList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComplexColTypeList(DorisParser.ComplexColTypeListContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#complexColType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComplexColType(DorisParser.ComplexColTypeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#commentSpec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCommentSpec(DorisParser.CommentSpecContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#sample}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSample(DorisParser.SampleContext ctx);
    /**
     * Visit a parse tree produced by the {@code sampleByPercentile} labeled alternative in {@link
     * DorisParser#sampleMethod}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSampleByPercentile(DorisParser.SampleByPercentileContext ctx);
    /**
     * Visit a parse tree produced by the {@code sampleByRows} labeled alternative in {@link
     * DorisParser#sampleMethod}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSampleByRows(DorisParser.SampleByRowsContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#tableSnapshot}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTableSnapshot(DorisParser.TableSnapshotContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#errorCapturingIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitErrorCapturingIdentifier(DorisParser.ErrorCapturingIdentifierContext ctx);
    /**
     * Visit a parse tree produced by the {@code errorIdent} labeled alternative in {@link
     * DorisParser#errorCapturingIdentifierExtra}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitErrorIdent(DorisParser.ErrorIdentContext ctx);
    /**
     * Visit a parse tree produced by the {@code realIdent} labeled alternative in {@link
     * DorisParser#errorCapturingIdentifierExtra}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRealIdent(DorisParser.RealIdentContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#identifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifier(DorisParser.IdentifierContext ctx);
    /**
     * Visit a parse tree produced by the {@code unquotedIdentifier} labeled alternative in {@link
     * DorisParser#strictIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnquotedIdentifier(DorisParser.UnquotedIdentifierContext ctx);
    /**
     * Visit a parse tree produced by the {@code quotedIdentifierAlternative} labeled alternative in
     * {@link DorisParser#strictIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQuotedIdentifierAlternative(DorisParser.QuotedIdentifierAlternativeContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#quotedIdentifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQuotedIdentifier(DorisParser.QuotedIdentifierContext ctx);
    /**
     * Visit a parse tree produced by the {@code integerLiteral} labeled alternative in {@link
     * DorisParser#number}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntegerLiteral(DorisParser.IntegerLiteralContext ctx);
    /**
     * Visit a parse tree produced by the {@code decimalLiteral} labeled alternative in {@link
     * DorisParser#number}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDecimalLiteral(DorisParser.DecimalLiteralContext ctx);
    /**
     * Visit a parse tree produced by {@link DorisParser#nonReserved}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNonReserved(DorisParser.NonReservedContext ctx);
}
