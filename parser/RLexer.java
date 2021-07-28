// Generated from R.g4 by ANTLR 4.9.2
 package parser; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, HEX=56, INT=57, FLOAT=58, COMPLEX=59, STRING=60, 
		ID=61, USER_OP=62, NL=63, WS=64;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "HEX", "INT", "HEXDIGIT", 
			"FLOAT", "DIGIT", "EXP", "COMPLEX", "STRING", "ESC", "UNICODE_ESCAPE", 
			"OCTAL_ESCAPE", "HEX_ESCAPE", "ID", "LETTER", "USER_OP", "COMMENT", "NL", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'[['", "']'", "'['", "'::'", "':::'", "'$'", "'@'", "'^'", 
			"'-'", "'+'", "':'", "'*'", "'/'", "'>'", "'>='", "'<'", "'<='", "'=='", 
			"'!='", "'!'", "'&'", "'&&'", "'|'", "'||'", "'~'", "'<-'", "'<<-'", 
			"'='", "'->'", "'->>'", "':='", "'function'", "'('", "')'", "'{'", "'}'", 
			"'if'", "'else'", "'for'", "'in'", "'while'", "'repeat'", "'?'", "'next'", 
			"'break'", "'NULL'", "'NA'", "'Inf'", "'NaN'", "'TRUE'", "'FALSE'", "','", 
			"'...'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "HEX", "INT", "FLOAT", 
			"COMPLEX", "STRING", "ID", "USER_OP", "NL", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public RLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "R.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2B\u0215\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3+\3"+
		"+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3"+
		"/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\3\67\3\67\38\38\39\39\39\69\u0147\n9\r9\169\u0148"+
		"\39\59\u014c\n9\3:\6:\u014f\n:\r:\16:\u0150\3:\5:\u0154\n:\3;\3;\3<\6"+
		"<\u0159\n<\r<\16<\u015a\3<\3<\7<\u015f\n<\f<\16<\u0162\13<\3<\5<\u0165"+
		"\n<\3<\5<\u0168\n<\3<\6<\u016b\n<\r<\16<\u016c\3<\5<\u0170\n<\3<\5<\u0173"+
		"\n<\3<\3<\6<\u0177\n<\r<\16<\u0178\3<\5<\u017c\n<\3<\5<\u017f\n<\5<\u0181"+
		"\n<\3=\3=\3>\3>\5>\u0187\n>\3>\3>\3?\3?\3?\3?\3?\3?\5?\u0191\n?\3@\3@"+
		"\3@\7@\u0196\n@\f@\16@\u0199\13@\3@\3@\3@\3@\7@\u019f\n@\f@\16@\u01a2"+
		"\13@\3@\3@\3@\3@\7@\u01a8\n@\f@\16@\u01ab\13@\3@\5@\u01ae\n@\3A\3A\3A"+
		"\3A\3A\5A\u01b5\nA\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\5B"+
		"\u01c7\nB\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u01d2\nC\3D\3D\3D\5D\u01d7\nD"+
		"\3E\3E\3E\5E\u01dc\nE\3E\3E\3E\7E\u01e1\nE\fE\16E\u01e4\13E\3E\3E\3E\3"+
		"E\7E\u01ea\nE\fE\16E\u01ed\13E\5E\u01ef\nE\3F\3F\3G\3G\7G\u01f5\nG\fG"+
		"\16G\u01f8\13G\3G\3G\3H\3H\7H\u01fe\nH\fH\16H\u0201\13H\3H\5H\u0204\n"+
		"H\3H\3H\3H\3H\3I\5I\u020b\nI\3I\3I\3J\6J\u0210\nJ\rJ\16J\u0211\3J\3J\7"+
		"\u0197\u01a0\u01a9\u01f6\u01ff\2K\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w<y\2{\2}=\177>\u0081\2\u0083\2"+
		"\u0085\2\u0087\2\u0089?\u008b\2\u008d@\u008f\2\u0091A\u0093B\3\2\17\4"+
		"\2ZZzz\4\2NNnn\5\2\62;CHch\4\2GGgg\4\2--//\4\2$$^^\4\2))^^\13\2$$))^^"+
		"cdhhppttvvxx\3\2\62\65\3\2\629\4\2\60\60aa\4\2C\\c|\5\2\13\13\16\16\""+
		"\"\2\u023a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2w\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0089\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\3\u0095\3\2\2\2\5\u0097\3\2\2\2\7\u009a\3\2\2\2\t\u009c"+
		"\3\2\2\2\13\u009e\3\2\2\2\r\u00a1\3\2\2\2\17\u00a5\3\2\2\2\21\u00a7\3"+
		"\2\2\2\23\u00a9\3\2\2\2\25\u00ab\3\2\2\2\27\u00ad\3\2\2\2\31\u00af\3\2"+
		"\2\2\33\u00b1\3\2\2\2\35\u00b3\3\2\2\2\37\u00b5\3\2\2\2!\u00b7\3\2\2\2"+
		"#\u00ba\3\2\2\2%\u00bc\3\2\2\2\'\u00bf\3\2\2\2)\u00c2\3\2\2\2+\u00c5\3"+
		"\2\2\2-\u00c7\3\2\2\2/\u00c9\3\2\2\2\61\u00cc\3\2\2\2\63\u00ce\3\2\2\2"+
		"\65\u00d1\3\2\2\2\67\u00d3\3\2\2\29\u00d6\3\2\2\2;\u00da\3\2\2\2=\u00dc"+
		"\3\2\2\2?\u00df\3\2\2\2A\u00e3\3\2\2\2C\u00e6\3\2\2\2E\u00ef\3\2\2\2G"+
		"\u00f1\3\2\2\2I\u00f3\3\2\2\2K\u00f5\3\2\2\2M\u00f7\3\2\2\2O\u00fa\3\2"+
		"\2\2Q\u00ff\3\2\2\2S\u0103\3\2\2\2U\u0106\3\2\2\2W\u010c\3\2\2\2Y\u0113"+
		"\3\2\2\2[\u0115\3\2\2\2]\u011a\3\2\2\2_\u0120\3\2\2\2a\u0125\3\2\2\2c"+
		"\u0128\3\2\2\2e\u012c\3\2\2\2g\u0130\3\2\2\2i\u0135\3\2\2\2k\u013b\3\2"+
		"\2\2m\u013d\3\2\2\2o\u0141\3\2\2\2q\u0143\3\2\2\2s\u014e\3\2\2\2u\u0155"+
		"\3\2\2\2w\u0180\3\2\2\2y\u0182\3\2\2\2{\u0184\3\2\2\2}\u0190\3\2\2\2\177"+
		"\u01ad\3\2\2\2\u0081\u01b4\3\2\2\2\u0083\u01c6\3\2\2\2\u0085\u01d1\3\2"+
		"\2\2\u0087\u01d3\3\2\2\2\u0089\u01ee\3\2\2\2\u008b\u01f0\3\2\2\2\u008d"+
		"\u01f2\3\2\2\2\u008f\u01fb\3\2\2\2\u0091\u020a\3\2\2\2\u0093\u020f\3\2"+
		"\2\2\u0095\u0096\7=\2\2\u0096\4\3\2\2\2\u0097\u0098\7]\2\2\u0098\u0099"+
		"\7]\2\2\u0099\6\3\2\2\2\u009a\u009b\7_\2\2\u009b\b\3\2\2\2\u009c\u009d"+
		"\7]\2\2\u009d\n\3\2\2\2\u009e\u009f\7<\2\2\u009f\u00a0\7<\2\2\u00a0\f"+
		"\3\2\2\2\u00a1\u00a2\7<\2\2\u00a2\u00a3\7<\2\2\u00a3\u00a4\7<\2\2\u00a4"+
		"\16\3\2\2\2\u00a5\u00a6\7&\2\2\u00a6\20\3\2\2\2\u00a7\u00a8\7B\2\2\u00a8"+
		"\22\3\2\2\2\u00a9\u00aa\7`\2\2\u00aa\24\3\2\2\2\u00ab\u00ac\7/\2\2\u00ac"+
		"\26\3\2\2\2\u00ad\u00ae\7-\2\2\u00ae\30\3\2\2\2\u00af\u00b0\7<\2\2\u00b0"+
		"\32\3\2\2\2\u00b1\u00b2\7,\2\2\u00b2\34\3\2\2\2\u00b3\u00b4\7\61\2\2\u00b4"+
		"\36\3\2\2\2\u00b5\u00b6\7@\2\2\u00b6 \3\2\2\2\u00b7\u00b8\7@\2\2\u00b8"+
		"\u00b9\7?\2\2\u00b9\"\3\2\2\2\u00ba\u00bb\7>\2\2\u00bb$\3\2\2\2\u00bc"+
		"\u00bd\7>\2\2\u00bd\u00be\7?\2\2\u00be&\3\2\2\2\u00bf\u00c0\7?\2\2\u00c0"+
		"\u00c1\7?\2\2\u00c1(\3\2\2\2\u00c2\u00c3\7#\2\2\u00c3\u00c4\7?\2\2\u00c4"+
		"*\3\2\2\2\u00c5\u00c6\7#\2\2\u00c6,\3\2\2\2\u00c7\u00c8\7(\2\2\u00c8."+
		"\3\2\2\2\u00c9\u00ca\7(\2\2\u00ca\u00cb\7(\2\2\u00cb\60\3\2\2\2\u00cc"+
		"\u00cd\7~\2\2\u00cd\62\3\2\2\2\u00ce\u00cf\7~\2\2\u00cf\u00d0\7~\2\2\u00d0"+
		"\64\3\2\2\2\u00d1\u00d2\7\u0080\2\2\u00d2\66\3\2\2\2\u00d3\u00d4\7>\2"+
		"\2\u00d4\u00d5\7/\2\2\u00d58\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7\u00d8\7"+
		">\2\2\u00d8\u00d9\7/\2\2\u00d9:\3\2\2\2\u00da\u00db\7?\2\2\u00db<\3\2"+
		"\2\2\u00dc\u00dd\7/\2\2\u00dd\u00de\7@\2\2\u00de>\3\2\2\2\u00df\u00e0"+
		"\7/\2\2\u00e0\u00e1\7@\2\2\u00e1\u00e2\7@\2\2\u00e2@\3\2\2\2\u00e3\u00e4"+
		"\7<\2\2\u00e4\u00e5\7?\2\2\u00e5B\3\2\2\2\u00e6\u00e7\7h\2\2\u00e7\u00e8"+
		"\7w\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7e\2\2\u00ea\u00eb\7v\2\2\u00eb"+
		"\u00ec\7k\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee\7p\2\2\u00eeD\3\2\2\2\u00ef"+
		"\u00f0\7*\2\2\u00f0F\3\2\2\2\u00f1\u00f2\7+\2\2\u00f2H\3\2\2\2\u00f3\u00f4"+
		"\7}\2\2\u00f4J\3\2\2\2\u00f5\u00f6\7\177\2\2\u00f6L\3\2\2\2\u00f7\u00f8"+
		"\7k\2\2\u00f8\u00f9\7h\2\2\u00f9N\3\2\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc"+
		"\7n\2\2\u00fc\u00fd\7u\2\2\u00fd\u00fe\7g\2\2\u00feP\3\2\2\2\u00ff\u0100"+
		"\7h\2\2\u0100\u0101\7q\2\2\u0101\u0102\7t\2\2\u0102R\3\2\2\2\u0103\u0104"+
		"\7k\2\2\u0104\u0105\7p\2\2\u0105T\3\2\2\2\u0106\u0107\7y\2\2\u0107\u0108"+
		"\7j\2\2\u0108\u0109\7k\2\2\u0109\u010a\7n\2\2\u010a\u010b\7g\2\2\u010b"+
		"V\3\2\2\2\u010c\u010d\7t\2\2\u010d\u010e\7g\2\2\u010e\u010f\7r\2\2\u010f"+
		"\u0110\7g\2\2\u0110\u0111\7c\2\2\u0111\u0112\7v\2\2\u0112X\3\2\2\2\u0113"+
		"\u0114\7A\2\2\u0114Z\3\2\2\2\u0115\u0116\7p\2\2\u0116\u0117\7g\2\2\u0117"+
		"\u0118\7z\2\2\u0118\u0119\7v\2\2\u0119\\\3\2\2\2\u011a\u011b\7d\2\2\u011b"+
		"\u011c\7t\2\2\u011c\u011d\7g\2\2\u011d\u011e\7c\2\2\u011e\u011f\7m\2\2"+
		"\u011f^\3\2\2\2\u0120\u0121\7P\2\2\u0121\u0122\7W\2\2\u0122\u0123\7N\2"+
		"\2\u0123\u0124\7N\2\2\u0124`\3\2\2\2\u0125\u0126\7P\2\2\u0126\u0127\7"+
		"C\2\2\u0127b\3\2\2\2\u0128\u0129\7K\2\2\u0129\u012a\7p\2\2\u012a\u012b"+
		"\7h\2\2\u012bd\3\2\2\2\u012c\u012d\7P\2\2\u012d\u012e\7c\2\2\u012e\u012f"+
		"\7P\2\2\u012ff\3\2\2\2\u0130\u0131\7V\2\2\u0131\u0132\7T\2\2\u0132\u0133"+
		"\7W\2\2\u0133\u0134\7G\2\2\u0134h\3\2\2\2\u0135\u0136\7H\2\2\u0136\u0137"+
		"\7C\2\2\u0137\u0138\7N\2\2\u0138\u0139\7U\2\2\u0139\u013a\7G\2\2\u013a"+
		"j\3\2\2\2\u013b\u013c\7.\2\2\u013cl\3\2\2\2\u013d\u013e\7\60\2\2\u013e"+
		"\u013f\7\60\2\2\u013f\u0140\7\60\2\2\u0140n\3\2\2\2\u0141\u0142\7\60\2"+
		"\2\u0142p\3\2\2\2\u0143\u0144\7\62\2\2\u0144\u0146\t\2\2\2\u0145\u0147"+
		"\5u;\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u014c\t\3\2\2\u014b\u014a\3\2"+
		"\2\2\u014b\u014c\3\2\2\2\u014cr\3\2\2\2\u014d\u014f\5y=\2\u014e\u014d"+
		"\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0153\3\2\2\2\u0152\u0154\t\3\2\2\u0153\u0152\3\2\2\2\u0153\u0154\3\2"+
		"\2\2\u0154t\3\2\2\2\u0155\u0156\t\4\2\2\u0156v\3\2\2\2\u0157\u0159\5y"+
		"=\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u0160\7\60\2\2\u015d\u015f\5"+
		"y=\2\u015e\u015d\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0165\5{"+
		">\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166"+
		"\u0168\t\3\2\2\u0167\u0166\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0181\3\2"+
		"\2\2\u0169\u016b\5y=\2\u016a\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a"+
		"\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u0170\5{>\2\u016f"+
		"\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u0173\t\3"+
		"\2\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0181\3\2\2\2\u0174"+
		"\u0176\7\60\2\2\u0175\u0177\5y=\2\u0176\u0175\3\2\2\2\u0177\u0178\3\2"+
		"\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\3\2\2\2\u017a"+
		"\u017c\5{>\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2"+
		"\2\u017d\u017f\t\3\2\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181"+
		"\3\2\2\2\u0180\u0158\3\2\2\2\u0180\u016a\3\2\2\2\u0180\u0174\3\2\2\2\u0181"+
		"x\3\2\2\2\u0182\u0183\4\62;\2\u0183z\3\2\2\2\u0184\u0186\t\5\2\2\u0185"+
		"\u0187\t\6\2\2\u0186\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2"+
		"\2\2\u0188\u0189\5s:\2\u0189|\3\2\2\2\u018a\u018b\5s:\2\u018b\u018c\7"+
		"k\2\2\u018c\u0191\3\2\2\2\u018d\u018e\5w<\2\u018e\u018f\7k\2\2\u018f\u0191"+
		"\3\2\2\2\u0190\u018a\3\2\2\2\u0190\u018d\3\2\2\2\u0191~\3\2\2\2\u0192"+
		"\u0197\7$\2\2\u0193\u0196\5\u0081A\2\u0194\u0196\n\7\2\2\u0195\u0193\3"+
		"\2\2\2\u0195\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0198\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u01ae\7$"+
		"\2\2\u019b\u01a0\7)\2\2\u019c\u019f\5\u0081A\2\u019d\u019f\n\b\2\2\u019e"+
		"\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3"+
		"\u01ae\7)\2\2\u01a4\u01a9\7b\2\2\u01a5\u01a8\5\u0081A\2\u01a6\u01a8\n"+
		"\b\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9"+
		"\u01aa\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2"+
		"\2\2\u01ac\u01ae\7b\2\2\u01ad\u0192\3\2\2\2\u01ad\u019b\3\2\2\2\u01ad"+
		"\u01a4\3\2\2\2\u01ae\u0080\3\2\2\2\u01af\u01b0\7^\2\2\u01b0\u01b5\t\t"+
		"\2\2\u01b1\u01b5\5\u0083B\2\u01b2\u01b5\5\u0087D\2\u01b3\u01b5\5\u0085"+
		"C\2\u01b4\u01af\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4"+
		"\u01b3\3\2\2\2\u01b5\u0082\3\2\2\2\u01b6\u01b7\7^\2\2\u01b7\u01b8\7w\2"+
		"\2\u01b8\u01b9\5u;\2\u01b9\u01ba\5u;\2\u01ba\u01bb\5u;\2\u01bb\u01bc\5"+
		"u;\2\u01bc\u01c7\3\2\2\2\u01bd\u01be\7^\2\2\u01be\u01bf\7w\2\2\u01bf\u01c0"+
		"\7}\2\2\u01c0\u01c1\5u;\2\u01c1\u01c2\5u;\2\u01c2\u01c3\5u;\2\u01c3\u01c4"+
		"\5u;\2\u01c4\u01c5\7\177\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01b6\3\2\2\2\u01c6"+
		"\u01bd\3\2\2\2\u01c7\u0084\3\2\2\2\u01c8\u01c9\7^\2\2\u01c9\u01ca\t\n"+
		"\2\2\u01ca\u01cb\t\13\2\2\u01cb\u01d2\t\13\2\2\u01cc\u01cd\7^\2\2\u01cd"+
		"\u01ce\t\13\2\2\u01ce\u01d2\t\13\2\2\u01cf\u01d0\7^\2\2\u01d0\u01d2\t"+
		"\13\2\2\u01d1\u01c8\3\2\2\2\u01d1\u01cc\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2"+
		"\u0086\3\2\2\2\u01d3\u01d4\7^\2\2\u01d4\u01d6\5u;\2\u01d5\u01d7\5u;\2"+
		"\u01d6\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u0088\3\2\2\2\u01d8\u01db"+
		"\7\60\2\2\u01d9\u01dc\5\u008bF\2\u01da\u01dc\t\f\2\2\u01db\u01d9\3\2\2"+
		"\2\u01db\u01da\3\2\2\2\u01dc\u01e2\3\2\2\2\u01dd\u01e1\5\u008bF\2\u01de"+
		"\u01e1\5y=\2\u01df\u01e1\t\f\2\2\u01e0\u01dd\3\2\2\2\u01e0\u01de\3\2\2"+
		"\2\u01e0\u01df\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3"+
		"\3\2\2\2\u01e3\u01ef\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01eb\5\u008bF"+
		"\2\u01e6\u01ea\5\u008bF\2\u01e7\u01ea\5y=\2\u01e8\u01ea\t\f\2\2\u01e9"+
		"\u01e6\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3\2"+
		"\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed"+
		"\u01eb\3\2\2\2\u01ee\u01d8\3\2\2\2\u01ee\u01e5\3\2\2\2\u01ef\u008a\3\2"+
		"\2\2\u01f0\u01f1\t\r\2\2\u01f1\u008c\3\2\2\2\u01f2\u01f6\7\'\2\2\u01f3"+
		"\u01f5\13\2\2\2\u01f4\u01f3\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f7\3"+
		"\2\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9"+
		"\u01fa\7\'\2\2\u01fa\u008e\3\2\2\2\u01fb\u01ff\7%\2\2\u01fc\u01fe\13\2"+
		"\2\2\u01fd\u01fc\3\2\2\2\u01fe\u0201\3\2\2\2\u01ff\u0200\3\2\2\2\u01ff"+
		"\u01fd\3\2\2\2\u0200\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0202\u0204\7\17"+
		"\2\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u0206\7\f\2\2\u0206\u0207\3\2\2\2\u0207\u0208\bH\2\2\u0208\u0090\3\2"+
		"\2\2\u0209\u020b\7\17\2\2\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u020c\3\2\2\2\u020c\u020d\7\f\2\2\u020d\u0092\3\2\2\2\u020e\u0210\t\16"+
		"\2\2\u020f\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u020f\3\2\2\2\u0211"+
		"\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\bJ\3\2\u0214\u0094\3\2"+
		"\2\2*\2\u0148\u014b\u0150\u0153\u015a\u0160\u0164\u0167\u016c\u016f\u0172"+
		"\u0178\u017b\u017e\u0180\u0186\u0190\u0195\u0197\u019e\u01a0\u01a7\u01a9"+
		"\u01ad\u01b4\u01c6\u01d1\u01d6\u01db\u01e0\u01e2\u01e9\u01eb\u01ee\u01f6"+
		"\u01ff\u0203\u020a\u0211\4\tA\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}