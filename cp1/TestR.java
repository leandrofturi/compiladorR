import org.antlr.v4.runtime.*;

public class TestR {
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if ( args.length>0 ) inputFile = args[0];
		System.out.println(inputFile);
		CharStream input = CharStreams.fromFileName(inputFile);
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
		RParser parser = new RParser(tokens);
		parser.setBuildParseTree(true);
		RuleContext tree = parser.prog();
		System.out.println(tree.toStringTree(parser));
	}
}