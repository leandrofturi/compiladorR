// Generated from R.g4 by ANTLR 4.9.2
 package parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RParser extends Parser {
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
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_exprlist = 2, RULE_formlist = 3, RULE_form = 4, 
		RULE_sublist = 5, RULE_sub = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "expr", "exprlist", "formlist", "form", "sublist", "sub"
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

	@Override
	public String getGrammarFileName() { return "R.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RParser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(RParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(RParser.NL, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__20) | (1L << T__25) | (1L << T__32) | (1L << T__33) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << HEX) | (1L << INT) | (1L << FLOAT) | (1L << COMPLEX) | (1L << STRING) | (1L << ID) | (1L << NL))) != 0)) {
				{
				setState(18);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
				case T__10:
				case T__20:
				case T__25:
				case T__32:
				case T__33:
				case T__35:
				case T__37:
				case T__39:
				case T__41:
				case T__42:
				case T__43:
				case T__44:
				case T__45:
				case T__46:
				case T__47:
				case T__48:
				case T__49:
				case T__50:
				case T__51:
				case HEX:
				case INT:
				case FLOAT:
				case COMPLEX:
				case STRING:
				case ID:
					{
					setState(14);
					expr(0);
					setState(15);
					_la = _input.LA(1);
					if ( !(_la==T__0 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case NL:
					{
					setState(17);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprNotFormulaContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprNotFormulaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprNotFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprINTContext extends ExprContext {
		public TerminalNode INT() { return getToken(RParser.INT, 0); }
		public ExprINTContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprINT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNAContext extends ExprContext {
		public ExprNAContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprNA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprValuePkgContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprValuePkgContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprValuePkg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprPexprPContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprPexprPContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprPexprP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprbreakContext extends ExprContext {
		public ExprbreakContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprbreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprWrappedinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode USER_OP() { return getToken(RParser.USER_OP, 0); }
		public ExprWrappedinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprWrappedin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSubsublistContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SublistContext sublist() {
			return getRuleContext(SublistContext.class,0);
		}
		public ExprSubsublistContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprSubsublist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprExtractContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprExtractContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprExtract(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCompoundContext extends ExprContext {
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public ExprCompoundContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprCompound(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSTRINGContext extends ExprContext {
		public TerminalNode STRING() { return getToken(RParser.STRING, 0); }
		public ExprSTRINGContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprSTRING(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAssignContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTRUEContext extends ExprContext {
		public ExprTRUEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprTRUE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprforContext extends ExprContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprforContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprfor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprwhileContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprwhileContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprwhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprOrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprInfContext extends ExprContext {
		public ExprInfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprInf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprifelseContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprifelseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprifelse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprHEXContext extends ExprContext {
		public TerminalNode HEX() { return getToken(RParser.HEX, 0); }
		public ExprHEXContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprHEX(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSignContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprSignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprSign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprHelpContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprHelpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprHelp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAssocRightContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAssocRightContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprAssocRight(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFALSEContext extends ExprContext {
		public ExprFALSEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprFALSE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSublistContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SublistContext sublist() {
			return getRuleContext(SublistContext.class,0);
		}
		public ExprSublistContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprSublist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNamespaceContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprNamespaceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprNamespace(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprEqualityContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprEqualityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFLOATContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(RParser.FLOAT, 0); }
		public ExprFLOATContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprFLOAT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCOMPLEXContext extends ExprContext {
		public TerminalNode COMPLEX() { return getToken(RParser.COMPLEX, 0); }
		public ExprCOMPLEXContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprCOMPLEX(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSumContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprSumContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDefineContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FormlistContext formlist() {
			return getRuleContext(FormlistContext.class,0);
		}
		public ExprDefineContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprDefine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNULLContext extends ExprContext {
		public ExprNULLContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprNULL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTimesContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprTimesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprrepeatContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprrepeatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprrepeat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprnextContext extends ExprContext {
		public ExprnextContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprnext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SublistContext sublist() {
			return getRuleContext(SublistContext.class,0);
		}
		public ExprCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIDContext extends ExprContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public ExprIDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprifContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprifContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNaNContext extends ExprContext {
		public ExprNaNContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprNaN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprEFormulaEContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprEFormulaEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprEFormulaE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new ExprSignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(26);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(27);
				expr(36);
				}
				break;
			case 2:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(T__20);
				setState(29);
				expr(30);
				}
				break;
			case 3:
				{
				_localctx = new ExprNotFormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(T__25);
				setState(31);
				expr(27);
				}
				break;
			case 4:
				{
				_localctx = new ExprDefineContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				match(T__32);
				setState(33);
				match(T__33);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__53) | (1L << T__54) | (1L << ID))) != 0)) {
					{
					setState(34);
					formlist();
					}
				}

				setState(37);
				match(T__34);
				setState(38);
				expr(24);
				}
				break;
			case 5:
				{
				_localctx = new ExprCompoundContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				match(T__35);
				setState(40);
				exprlist();
				setState(41);
				match(T__36);
				}
				break;
			case 6:
				{
				_localctx = new ExprifContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(T__37);
				setState(44);
				match(T__33);
				setState(45);
				expr(0);
				setState(46);
				match(T__34);
				setState(47);
				expr(21);
				}
				break;
			case 7:
				{
				_localctx = new ExprifelseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				match(T__37);
				setState(50);
				match(T__33);
				setState(51);
				expr(0);
				setState(52);
				match(T__34);
				setState(53);
				expr(0);
				setState(54);
				match(T__38);
				setState(55);
				expr(20);
				}
				break;
			case 8:
				{
				_localctx = new ExprforContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				match(T__39);
				setState(58);
				match(T__33);
				setState(59);
				match(ID);
				setState(60);
				match(T__40);
				setState(61);
				expr(0);
				setState(62);
				match(T__34);
				setState(63);
				expr(19);
				}
				break;
			case 9:
				{
				_localctx = new ExprwhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(T__41);
				setState(66);
				match(T__33);
				setState(67);
				expr(0);
				setState(68);
				match(T__34);
				setState(69);
				expr(18);
				}
				break;
			case 10:
				{
				_localctx = new ExprrepeatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(T__42);
				setState(72);
				expr(17);
				}
				break;
			case 11:
				{
				_localctx = new ExprHelpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(T__43);
				setState(74);
				expr(16);
				}
				break;
			case 12:
				{
				_localctx = new ExprnextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				match(T__44);
				}
				break;
			case 13:
				{
				_localctx = new ExprbreakContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(T__45);
				}
				break;
			case 14:
				{
				_localctx = new ExprPexprPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(T__33);
				setState(78);
				expr(0);
				setState(79);
				match(T__34);
				}
				break;
			case 15:
				{
				_localctx = new ExprIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				match(ID);
				}
				break;
			case 16:
				{
				_localctx = new ExprSTRINGContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(STRING);
				}
				break;
			case 17:
				{
				_localctx = new ExprHEXContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(HEX);
				}
				break;
			case 18:
				{
				_localctx = new ExprINTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(INT);
				}
				break;
			case 19:
				{
				_localctx = new ExprFLOATContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(FLOAT);
				}
				break;
			case 20:
				{
				_localctx = new ExprCOMPLEXContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(COMPLEX);
				}
				break;
			case 21:
				{
				_localctx = new ExprNULLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(T__46);
				}
				break;
			case 22:
				{
				_localctx = new ExprNAContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(T__47);
				}
				break;
			case 23:
				{
				_localctx = new ExprInfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(T__48);
				}
				break;
			case 24:
				{
				_localctx = new ExprNaNContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(T__49);
				}
				break;
			case 25:
				{
				_localctx = new ExprTRUEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(T__50);
				}
				break;
			case 26:
				{
				_localctx = new ExprFALSEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(T__51);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExprValuePkgContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 39))) throw new FailedPredicateException(this, "precpred(_ctx, 39)");
						setState(96);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(97);
						expr(40);
						}
						break;
					case 2:
						{
						_localctx = new ExprExtractContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(99);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						expr(39);
						}
						break;
					case 3:
						{
						_localctx = new ExprAssocRightContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(102);
						match(T__8);
						setState(103);
						expr(37);
						}
						break;
					case 4:
						{
						_localctx = new ExprNamespaceContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(105);
						match(T__11);
						setState(106);
						expr(36);
						}
						break;
					case 5:
						{
						_localctx = new ExprWrappedinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(108);
						match(USER_OP);
						setState(109);
						expr(35);
						}
						break;
					case 6:
						{
						_localctx = new ExprTimesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(111);
						((ExprTimesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((ExprTimesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						expr(34);
						}
						break;
					case 7:
						{
						_localctx = new ExprSumContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(114);
						((ExprSumContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__10) ) {
							((ExprSumContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(115);
						expr(33);
						}
						break;
					case 8:
						{
						_localctx = new ExprEqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(117);
						((ExprEqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
							((ExprEqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						expr(32);
						}
						break;
					case 9:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(120);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(121);
						expr(30);
						}
						break;
					case 10:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(123);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(124);
						expr(29);
						}
						break;
					case 11:
						{
						_localctx = new ExprEFormulaEContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(126);
						match(T__25);
						setState(127);
						expr(27);
						}
						break;
					case 12:
						{
						_localctx = new ExprAssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(129);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(130);
						expr(26);
						}
						break;
					case 13:
						{
						_localctx = new ExprSubsublistContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 41))) throw new FailedPredicateException(this, "precpred(_ctx, 41)");
						setState(132);
						match(T__1);
						setState(133);
						sublist();
						setState(134);
						match(T__2);
						setState(135);
						match(T__2);
						}
						break;
					case 14:
						{
						_localctx = new ExprSublistContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 40))) throw new FailedPredicateException(this, "precpred(_ctx, 40)");
						setState(138);
						match(T__3);
						setState(139);
						sublist();
						setState(140);
						match(T__2);
						}
						break;
					case 15:
						{
						_localctx = new ExprCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(143);
						match(T__33);
						setState(144);
						sublist();
						setState(145);
						match(T__34);
						}
						break;
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprlistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(RParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(RParser.NL, i);
		}
		public ExprlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitExprlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprlistContext exprlist() throws RecognitionException {
		ExprlistContext _localctx = new ExprlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exprlist);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__20:
			case T__25:
			case T__32:
			case T__33:
			case T__35:
			case T__37:
			case T__39:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case HEX:
			case INT:
			case FLOAT:
			case COMPLEX:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				expr(0);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0 || _la==NL) {
					{
					{
					setState(153);
					_la = _input.LA(1);
					if ( !(_la==T__0 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__20) | (1L << T__25) | (1L << T__32) | (1L << T__33) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << HEX) | (1L << INT) | (1L << FLOAT) | (1L << COMPLEX) | (1L << STRING) | (1L << ID))) != 0)) {
						{
						setState(154);
						expr(0);
						}
					}

					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormlistContext extends ParserRuleContext {
		public List<FormContext> form() {
			return getRuleContexts(FormContext.class);
		}
		public FormContext form(int i) {
			return getRuleContext(FormContext.class,i);
		}
		public FormlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitFormlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormlistContext formlist() throws RecognitionException {
		FormlistContext _localctx = new FormlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			form();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__52) {
				{
				{
				setState(166);
				match(T__52);
				setState(167);
				form();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormContext extends ParserRuleContext {
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
	 
		public FormContext() { }
		public void copyFrom(FormContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormIDContext extends FormContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public FormIDContext(FormContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitFormID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FormAssignContext extends FormContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FormAssignContext(FormContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitFormAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FormVaragsContext extends FormContext {
		public FormVaragsContext(FormContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitFormVarags(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FormPointContext extends FormContext {
		public FormPointContext(FormContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitFormPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_form);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new FormIDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(ID);
				}
				break;
			case 2:
				_localctx = new FormAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(ID);
				setState(175);
				match(T__28);
				setState(176);
				expr(0);
				}
				break;
			case 3:
				_localctx = new FormVaragsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(T__53);
				}
				break;
			case 4:
				_localctx = new FormPointContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				match(T__54);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SublistContext extends ParserRuleContext {
		public List<SubContext> sub() {
			return getRuleContexts(SubContext.class);
		}
		public SubContext sub(int i) {
			return getRuleContext(SubContext.class,i);
		}
		public SublistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sublist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSublist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SublistContext sublist() throws RecognitionException {
		SublistContext _localctx = new SublistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sublist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			sub();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__52) {
				{
				{
				setState(182);
				match(T__52);
				setState(183);
				sub();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubContext extends ParserRuleContext {
		public SubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub; }
	 
		public SubContext() { }
		public void copyFrom(SubContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubIDContext extends SubContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public SubIDContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubAssignNULLContext extends SubContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubAssignNULLContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubAssignNULL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubVaragsContext extends SubContext {
		public SubVaragsContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubVarags(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubSTRINGContext extends SubContext {
		public TerminalNode STRING() { return getToken(RParser.STRING, 0); }
		public SubSTRINGContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubSTRING(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubPointContext extends SubContext {
		public SubPointContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubPoint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubAssignIDContext extends SubContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubAssignIDContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubAssignID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubEmptyContext extends SubContext {
		public SubEmptyContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubNULLContext extends SubContext {
		public SubNULLContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubNULL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubAssignSTRINGContext extends SubContext {
		public TerminalNode STRING() { return getToken(RParser.STRING, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubAssignSTRINGContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubAssignSTRING(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends SubContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubExprContext(SubContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RVisitor ) return ((RVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubContext sub() throws RecognitionException {
		SubContext _localctx = new SubContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sub);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new SubExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				expr(0);
				}
				break;
			case 2:
				_localctx = new SubIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(ID);
				setState(191);
				match(T__28);
				}
				break;
			case 3:
				_localctx = new SubAssignIDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(ID);
				setState(193);
				match(T__28);
				setState(194);
				expr(0);
				}
				break;
			case 4:
				_localctx = new SubSTRINGContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				match(STRING);
				setState(196);
				match(T__28);
				}
				break;
			case 5:
				_localctx = new SubAssignSTRINGContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				match(STRING);
				setState(198);
				match(T__28);
				setState(199);
				expr(0);
				}
				break;
			case 6:
				_localctx = new SubNULLContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(200);
				match(T__46);
				setState(201);
				match(T__28);
				}
				break;
			case 7:
				_localctx = new SubAssignNULLContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(202);
				match(T__46);
				setState(203);
				match(T__28);
				setState(204);
				expr(0);
				}
				break;
			case 8:
				_localctx = new SubVaragsContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(205);
				match(T__53);
				}
				break;
			case 9:
				_localctx = new SubPointContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(206);
				match(T__54);
				}
				break;
			case 10:
				_localctx = new SubEmptyContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 39);
		case 1:
			return precpred(_ctx, 38);
		case 2:
			return precpred(_ctx, 37);
		case 3:
			return precpred(_ctx, 35);
		case 4:
			return precpred(_ctx, 34);
		case 5:
			return precpred(_ctx, 33);
		case 6:
			return precpred(_ctx, 32);
		case 7:
			return precpred(_ctx, 31);
		case 8:
			return precpred(_ctx, 29);
		case 9:
			return precpred(_ctx, 28);
		case 10:
			return precpred(_ctx, 26);
		case 11:
			return precpred(_ctx, 25);
		case 12:
			return precpred(_ctx, 41);
		case 13:
			return precpred(_ctx, 40);
		case 14:
			return precpred(_ctx, 23);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u00d5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\7\2\25"+
		"\n\2\f\2\16\2\30\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3&\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3`\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u0096\n\3\f\3\16\3\u0099\13\3\3\4"+
		"\3\4\3\4\5\4\u009e\n\4\7\4\u00a0\n\4\f\4\16\4\u00a3\13\4\3\4\5\4\u00a6"+
		"\n\4\3\5\3\5\3\5\7\5\u00ab\n\5\f\5\16\5\u00ae\13\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6\u00b6\n\6\3\7\3\7\3\7\7\7\u00bb\n\7\f\7\16\7\u00be\13\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b\u00d3\n\b\3\b\2\3\4\t\2\4\6\b\n\f\16\2\13\4\2\3\3AA\3\2\f\r\3\2\7"+
		"\b\3\2\t\n\3\2\17\20\3\2\21\26\3\2\30\31\3\2\32\33\3\2\35\"\2\u0109\2"+
		"\26\3\2\2\2\4_\3\2\2\2\6\u00a5\3\2\2\2\b\u00a7\3\2\2\2\n\u00b5\3\2\2\2"+
		"\f\u00b7\3\2\2\2\16\u00d2\3\2\2\2\20\21\5\4\3\2\21\22\t\2\2\2\22\25\3"+
		"\2\2\2\23\25\7A\2\2\24\20\3\2\2\2\24\23\3\2\2\2\25\30\3\2\2\2\26\24\3"+
		"\2\2\2\26\27\3\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2\31\32\7\2\2\3\32\3\3"+
		"\2\2\2\33\34\b\3\1\2\34\35\t\3\2\2\35`\5\4\3&\36\37\7\27\2\2\37`\5\4\3"+
		"  !\7\34\2\2!`\5\4\3\35\"#\7#\2\2#%\7$\2\2$&\5\b\5\2%$\3\2\2\2%&\3\2\2"+
		"\2&\'\3\2\2\2\'(\7%\2\2(`\5\4\3\32)*\7&\2\2*+\5\6\4\2+,\7\'\2\2,`\3\2"+
		"\2\2-.\7(\2\2./\7$\2\2/\60\5\4\3\2\60\61\7%\2\2\61\62\5\4\3\27\62`\3\2"+
		"\2\2\63\64\7(\2\2\64\65\7$\2\2\65\66\5\4\3\2\66\67\7%\2\2\678\5\4\3\2"+
		"89\7)\2\29:\5\4\3\26:`\3\2\2\2;<\7*\2\2<=\7$\2\2=>\7?\2\2>?\7+\2\2?@\5"+
		"\4\3\2@A\7%\2\2AB\5\4\3\25B`\3\2\2\2CD\7,\2\2DE\7$\2\2EF\5\4\3\2FG\7%"+
		"\2\2GH\5\4\3\24H`\3\2\2\2IJ\7-\2\2J`\5\4\3\23KL\7.\2\2L`\5\4\3\22M`\7"+
		"/\2\2N`\7\60\2\2OP\7$\2\2PQ\5\4\3\2QR\7%\2\2R`\3\2\2\2S`\7?\2\2T`\7>\2"+
		"\2U`\7:\2\2V`\7;\2\2W`\7<\2\2X`\7=\2\2Y`\7\61\2\2Z`\7\62\2\2[`\7\63\2"+
		"\2\\`\7\64\2\2]`\7\65\2\2^`\7\66\2\2_\33\3\2\2\2_\36\3\2\2\2_ \3\2\2\2"+
		"_\"\3\2\2\2_)\3\2\2\2_-\3\2\2\2_\63\3\2\2\2_;\3\2\2\2_C\3\2\2\2_I\3\2"+
		"\2\2_K\3\2\2\2_M\3\2\2\2_N\3\2\2\2_O\3\2\2\2_S\3\2\2\2_T\3\2\2\2_U\3\2"+
		"\2\2_V\3\2\2\2_W\3\2\2\2_X\3\2\2\2_Y\3\2\2\2_Z\3\2\2\2_[\3\2\2\2_\\\3"+
		"\2\2\2_]\3\2\2\2_^\3\2\2\2`\u0097\3\2\2\2ab\f)\2\2bc\t\4\2\2c\u0096\5"+
		"\4\3*de\f(\2\2ef\t\5\2\2f\u0096\5\4\3)gh\f\'\2\2hi\7\13\2\2i\u0096\5\4"+
		"\3\'jk\f%\2\2kl\7\16\2\2l\u0096\5\4\3&mn\f$\2\2no\7@\2\2o\u0096\5\4\3"+
		"%pq\f#\2\2qr\t\6\2\2r\u0096\5\4\3$st\f\"\2\2tu\t\3\2\2u\u0096\5\4\3#v"+
		"w\f!\2\2wx\t\7\2\2x\u0096\5\4\3\"yz\f\37\2\2z{\t\b\2\2{\u0096\5\4\3 |"+
		"}\f\36\2\2}~\t\t\2\2~\u0096\5\4\3\37\177\u0080\f\34\2\2\u0080\u0081\7"+
		"\34\2\2\u0081\u0096\5\4\3\35\u0082\u0083\f\33\2\2\u0083\u0084\t\n\2\2"+
		"\u0084\u0096\5\4\3\34\u0085\u0086\f+\2\2\u0086\u0087\7\4\2\2\u0087\u0088"+
		"\5\f\7\2\u0088\u0089\7\5\2\2\u0089\u008a\7\5\2\2\u008a\u0096\3\2\2\2\u008b"+
		"\u008c\f*\2\2\u008c\u008d\7\6\2\2\u008d\u008e\5\f\7\2\u008e\u008f\7\5"+
		"\2\2\u008f\u0096\3\2\2\2\u0090\u0091\f\31\2\2\u0091\u0092\7$\2\2\u0092"+
		"\u0093\5\f\7\2\u0093\u0094\7%\2\2\u0094\u0096\3\2\2\2\u0095a\3\2\2\2\u0095"+
		"d\3\2\2\2\u0095g\3\2\2\2\u0095j\3\2\2\2\u0095m\3\2\2\2\u0095p\3\2\2\2"+
		"\u0095s\3\2\2\2\u0095v\3\2\2\2\u0095y\3\2\2\2\u0095|\3\2\2\2\u0095\177"+
		"\3\2\2\2\u0095\u0082\3\2\2\2\u0095\u0085\3\2\2\2\u0095\u008b\3\2\2\2\u0095"+
		"\u0090\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\5\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u00a1\5\4\3\2\u009b\u009d"+
		"\t\2\2\2\u009c\u009e\5\4\3\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00a0\3\2\2\2\u009f\u009b\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a6\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a6\3\2\2\2\u00a5\u009a\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\7\3\2\2\2"+
		"\u00a7\u00ac\5\n\6\2\u00a8\u00a9\7\67\2\2\u00a9\u00ab\5\n\6\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\t\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b6\7?\2\2\u00b0\u00b1\7?\2\2\u00b1"+
		"\u00b2\7\37\2\2\u00b2\u00b6\5\4\3\2\u00b3\u00b6\78\2\2\u00b4\u00b6\79"+
		"\2\2\u00b5\u00af\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\13\3\2\2\2\u00b7\u00bc\5\16\b\2\u00b8\u00b9\7\67"+
		"\2\2\u00b9\u00bb\5\16\b\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\r\3\2\2\2\u00be\u00bc\3\2\2\2"+
		"\u00bf\u00d3\5\4\3\2\u00c0\u00c1\7?\2\2\u00c1\u00d3\7\37\2\2\u00c2\u00c3"+
		"\7?\2\2\u00c3\u00c4\7\37\2\2\u00c4\u00d3\5\4\3\2\u00c5\u00c6\7>\2\2\u00c6"+
		"\u00d3\7\37\2\2\u00c7\u00c8\7>\2\2\u00c8\u00c9\7\37\2\2\u00c9\u00d3\5"+
		"\4\3\2\u00ca\u00cb\7\61\2\2\u00cb\u00d3\7\37\2\2\u00cc\u00cd\7\61\2\2"+
		"\u00cd\u00ce\7\37\2\2\u00ce\u00d3\5\4\3\2\u00cf\u00d3\78\2\2\u00d0\u00d3"+
		"\79\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00bf\3\2\2\2\u00d2\u00c0\3\2\2\2\u00d2"+
		"\u00c2\3\2\2\2\u00d2\u00c5\3\2\2\2\u00d2\u00c7\3\2\2\2\u00d2\u00ca\3\2"+
		"\2\2\u00d2\u00cc\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\17\3\2\2\2\17\24\26%_\u0095\u0097\u009d\u00a1\u00a5"+
		"\u00ac\u00b5\u00bc\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}