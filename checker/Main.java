package checker;

import org.antlr.v4.runtime.*;

import parser.RLexer;
import parser.RFilter;
import parser.RParser;

public class Main {
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if ( args.length>0 ) inputFile = args[0];
		System.out.println(inputFile);
		CharStream input = CharStreams.fromFileName(inputFile);

		// Lexer
		RLexer lexer = new RLexer(input);
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
		for (Object tok : tokens.getTokens()) {
			System.out.println(tok);
		}

		// Parser
		RParser parser = new RParser(tokens);
		parser.setBuildParseTree(true);
		RuleContext tree = parser.prog();
		System.out.println(tree.toStringTree(parser));

		// Checker
		SemanticChecker checker = new SemanticChecker();
		checker.visit(tree);
		if (checker.hasPassed()) {
			System.out.println("PARSE SUCCESSFUL!");
			checker.printTables();
		}
	}
}