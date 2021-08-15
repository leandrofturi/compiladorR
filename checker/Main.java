package checker;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.RLexer;
import parser.RFilter;
import parser.RParser;

public class Main {

	/*
	 *  Programa principal para funcionamento do compilador.
	 */
	public static void main(String[] args) throws IOException {
		// Cria um CharStream que lê os caracteres de um arquivo.
		CharStream input = CharStreams.fromFileName(args[0]);

		// Cria um lexer que consome a entrada do CharStream.
		RLexer lexer = new RLexer(input);

		// Cria um buffer de tokens vindos do lexer.
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Print tokens BEFORE filtering
//		tokens.fill();
//		for (Object tok : tokens.getTokens()) {
//			System.out.println(tok);
//		}

		RFilter filter = new RFilter(tokens);
		filter.stream(); // call start rule: stream
		tokens.seek(0);

		// Print tokens AFTER filtering
//		for (Object tok : tokens.getTokens()) {
//			System.out.println(tok);
//		}

		// Cria um parser que consome os tokens do buffer.
		RParser parser = new RParser(tokens);

		// Começa o processo de parsing na regra 'prog'.
		ParseTree tree = parser.prog();
		System.out.println(tree.toStringTree(parser));

		if (parser.getNumberOfSyntaxErrors() != 0) {
			// Houve algum erro sintático. Termina a compilação aqui.
			return;
		}

		// Cria o analisador semântico e visita a ParseTree para
		// fazer a análise.
		SemanticChecker checker = new SemanticChecker();
		checker.visit(tree);

		// Saída final.
		if (checker.hasPassed()) {
			System.out.println("PARSE SUCCESSFUL!");
			checker.printTables();
		}
	}

}
