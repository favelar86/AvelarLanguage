// Generated from Avelarlang.g4 by ANTLR 4.13.2
package br.com.ufabc.avelarlanguage.parser;

    import br.com.ufabc.avelarlanguage.datastructures.AvlSymbol;
    import br.com.ufabc.avelarlanguage.datastructures.AvlSymbolTable;
    import br.com.ufabc.avelarlanguage.datastructures.AvlVariable;
    import br.com.ufabc.avelarlanguage.exceptions.AvlSemanticException;
    import br.com.ufabc.avelarlanguage.ast.AbstractCommand;
    import br.com.ufabc.avelarlanguage.ast.CommandLeitura;
    import br.com.ufabc.avelarlanguage.ast.CommandEscrita;
    import br.com.ufabc.avelarlanguage.ast.CommandAtribuicao;
    import br.com.ufabc.avelarlanguage.ast.CommandDecisao;
    import br.com.ufabc.avelarlanguage.ast.AvlProgram;
    import java.util.ArrayList;
    import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AvelarlangParser}.
 */
public interface AvelarlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(AvelarlangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(AvelarlangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(AvelarlangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(AvelarlangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(AvelarlangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(AvelarlangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(AvelarlangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(AvelarlangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(AvelarlangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(AvelarlangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(AvelarlangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(AvelarlangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(AvelarlangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(AvelarlangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(AvelarlangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(AvelarlangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(AvelarlangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(AvelarlangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(AvelarlangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(AvelarlangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AvelarlangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AvelarlangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AvelarlangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(AvelarlangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AvelarlangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(AvelarlangParser.TermoContext ctx);
}