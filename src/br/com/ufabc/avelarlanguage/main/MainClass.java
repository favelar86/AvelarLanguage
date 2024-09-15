package br.com.ufabc.avelarlanguage.main;

import br.com.ufabc.avelarlanguage.exceptions.AvlSemanticException;
import br.com.ufabc.avelarlanguage.parser.AvelarlangLexer;
import br.com.ufabc.avelarlanguage.parser.AvelarlangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/* esta é a classe que é responsável por criar a interação com o usuário
 * instanciando nosso parser e apontando para o arquivo fonte
 *
 * Arquivo fonte: extensao .avl
 *
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            AvelarlangLexer lexer;
            AvelarlangParser parser;

            // leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
            lexer = new AvelarlangLexer(CharStreams.fromFileName("input.avl"));

            // crio um "fluxo de tokens" para passar para o PARSER
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            // crio meu parser a partir desse tokenStream
            parser = new AvelarlangParser(tokenStream);

            parser.prog();

            System.out.println("Compilation Successful");

            parser.exibeComandos();

            parser.generateCode();
        }
        catch(AvlSemanticException ex) {
            System.err.println("Semantic error - " +ex.getMessage());
        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.err.println("ERROR " +ex.getMessage());
        }
    }
}
