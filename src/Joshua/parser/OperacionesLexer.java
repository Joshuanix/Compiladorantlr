// Generated from Operaciones.g4 by ANTLR 4.8
package Joshua.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OperacionesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PR=1, OR=2, AND=3, EQ=4, NEQ=5, GT=6, LT=7, GTEQ=8, LTEQ=9, PLUS=10, MINUS=11, 
		MULT=12, DIV=13, MOD=14, POW=15, NOT=16, ENTERO=17, SCOL=18, ASSIGN=19, 
		OPAR=20, CPAR=21, OBRACE=22, CBRACE=23, TRUE=24, FALSE=25, NIL=26, IF=27, 
		ELSE=28, WHILE=29, LOG=30, ID=31, INT=32, FLOAT=33, STRING=34, COMMENT=35, 
		SPACE=36, OTHER=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PR", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "POW", "NOT", "ENTERO", "SCOL", "ASSIGN", "OPAR", 
			"CPAR", "OBRACE", "CBRACE", "TRUE", "FALSE", "NIL", "IF", "ELSE", "WHILE", 
			"LOG", "ID", "INT", "FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'progra()'", "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "'pit'", "';'", 
			"'='", "'('", "')'", "'{'", "'}'", "'true'", "'false'", "'nil'", "'si'", 
			"'sino'", "'mientras'", "'imprimir'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PR", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", 
			"MINUS", "MULT", "DIV", "MOD", "POW", "NOT", "ENTERO", "SCOL", "ASSIGN", 
			"OPAR", "CPAR", "OBRACE", "CBRACE", "TRUE", "FALSE", "NIL", "IF", "ELSE", 
			"WHILE", "LOG", "ID", "INT", "FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
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


	public OperacionesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Operaciones.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u00fc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \7 \u00b6\n \f \16 \u00b9\13 \3!\6!\u00bc\n"+
		"!\r!\16!\u00bd\3\"\6\"\u00c1\n\"\r\"\16\"\u00c2\3\"\3\"\7\"\u00c7\n\""+
		"\f\"\16\"\u00ca\13\"\3\"\3\"\6\"\u00ce\n\"\r\"\16\"\u00cf\5\"\u00d2\n"+
		"\"\3#\3#\3#\3#\7#\u00d8\n#\f#\16#\u00db\13#\3#\3#\3$\3$\3$\3$\7$\u00e3"+
		"\n$\f$\16$\u00e6\13$\3$\3$\3$\3$\7$\u00ec\n$\f$\16$\u00ef\13$\3$\3$\5"+
		"$\u00f3\n$\3$\3$\3%\3%\3%\3%\3&\3&\3\u00ed\2\'\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2"+
		"\b\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\2\u0106\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5V\3\2\2\2\7"+
		"Y\3\2\2\2\t\\\3\2\2\2\13_\3\2\2\2\rb\3\2\2\2\17d\3\2\2\2\21f\3\2\2\2\23"+
		"i\3\2\2\2\25l\3\2\2\2\27n\3\2\2\2\31p\3\2\2\2\33r\3\2\2\2\35t\3\2\2\2"+
		"\37v\3\2\2\2!x\3\2\2\2#z\3\2\2\2%~\3\2\2\2\'\u0080\3\2\2\2)\u0082\3\2"+
		"\2\2+\u0084\3\2\2\2-\u0086\3\2\2\2/\u0088\3\2\2\2\61\u008a\3\2\2\2\63"+
		"\u008f\3\2\2\2\65\u0095\3\2\2\2\67\u0099\3\2\2\29\u009c\3\2\2\2;\u00a1"+
		"\3\2\2\2=\u00aa\3\2\2\2?\u00b3\3\2\2\2A\u00bb\3\2\2\2C\u00d1\3\2\2\2E"+
		"\u00d3\3\2\2\2G\u00f2\3\2\2\2I\u00f6\3\2\2\2K\u00fa\3\2\2\2MN\7r\2\2N"+
		"O\7t\2\2OP\7q\2\2PQ\7i\2\2QR\7t\2\2RS\7c\2\2ST\7*\2\2TU\7+\2\2U\4\3\2"+
		"\2\2VW\7~\2\2WX\7~\2\2X\6\3\2\2\2YZ\7(\2\2Z[\7(\2\2[\b\3\2\2\2\\]\7?\2"+
		"\2]^\7?\2\2^\n\3\2\2\2_`\7#\2\2`a\7?\2\2a\f\3\2\2\2bc\7@\2\2c\16\3\2\2"+
		"\2de\7>\2\2e\20\3\2\2\2fg\7@\2\2gh\7?\2\2h\22\3\2\2\2ij\7>\2\2jk\7?\2"+
		"\2k\24\3\2\2\2lm\7-\2\2m\26\3\2\2\2no\7/\2\2o\30\3\2\2\2pq\7,\2\2q\32"+
		"\3\2\2\2rs\7\61\2\2s\34\3\2\2\2tu\7\'\2\2u\36\3\2\2\2vw\7`\2\2w \3\2\2"+
		"\2xy\7#\2\2y\"\3\2\2\2z{\7r\2\2{|\7k\2\2|}\7v\2\2}$\3\2\2\2~\177\7=\2"+
		"\2\177&\3\2\2\2\u0080\u0081\7?\2\2\u0081(\3\2\2\2\u0082\u0083\7*\2\2\u0083"+
		"*\3\2\2\2\u0084\u0085\7+\2\2\u0085,\3\2\2\2\u0086\u0087\7}\2\2\u0087."+
		"\3\2\2\2\u0088\u0089\7\177\2\2\u0089\60\3\2\2\2\u008a\u008b\7v\2\2\u008b"+
		"\u008c\7t\2\2\u008c\u008d\7w\2\2\u008d\u008e\7g\2\2\u008e\62\3\2\2\2\u008f"+
		"\u0090\7h\2\2\u0090\u0091\7c\2\2\u0091\u0092\7n\2\2\u0092\u0093\7u\2\2"+
		"\u0093\u0094\7g\2\2\u0094\64\3\2\2\2\u0095\u0096\7p\2\2\u0096\u0097\7"+
		"k\2\2\u0097\u0098\7n\2\2\u0098\66\3\2\2\2\u0099\u009a\7u\2\2\u009a\u009b"+
		"\7k\2\2\u009b8\3\2\2\2\u009c\u009d\7u\2\2\u009d\u009e\7k\2\2\u009e\u009f"+
		"\7p\2\2\u009f\u00a0\7q\2\2\u00a0:\3\2\2\2\u00a1\u00a2\7o\2\2\u00a2\u00a3"+
		"\7k\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7v\2\2\u00a6"+
		"\u00a7\7t\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7u\2\2\u00a9<\3\2\2\2\u00aa"+
		"\u00ab\7k\2\2\u00ab\u00ac\7o\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7t\2\2"+
		"\u00ae\u00af\7k\2\2\u00af\u00b0\7o\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2"+
		"\7t\2\2\u00b2>\3\2\2\2\u00b3\u00b7\t\2\2\2\u00b4\u00b6\t\3\2\2\u00b5\u00b4"+
		"\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"@\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\t\4\2\2\u00bb\u00ba\3\2\2\2"+
		"\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00beB\3"+
		"\2\2\2\u00bf\u00c1\t\4\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c8\7\60"+
		"\2\2\u00c5\u00c7\t\4\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00d2\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00cb\u00cd\7\60\2\2\u00cc\u00ce\t\4\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2"+
		"\2\2\u00d1\u00c0\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d2D\3\2\2\2\u00d3\u00d9"+
		"\7$\2\2\u00d4\u00d8\n\5\2\2\u00d5\u00d6\7$\2\2\u00d6\u00d8\7$\2\2\u00d7"+
		"\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00dd\7$\2\2\u00ddF\3\2\2\2\u00de\u00df\7\61\2\2\u00df\u00e0\7\61\2\2"+
		"\u00e0\u00e4\3\2\2\2\u00e1\u00e3\n\6\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00f3\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e7\u00e8\7\61\2\2\u00e8\u00e9\7,\2\2\u00e9\u00ed\3\2"+
		"\2\2\u00ea\u00ec\13\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ed\3\2"+
		"\2\2\u00f0\u00f1\7,\2\2\u00f1\u00f3\7\61\2\2\u00f2\u00de\3\2\2\2\u00f2"+
		"\u00e7\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b$\2\2\u00f5H\3\2\2\2\u00f6"+
		"\u00f7\t\7\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\b%\2\2\u00f9J\3\2\2\2\u00fa"+
		"\u00fb\13\2\2\2\u00fbL\3\2\2\2\16\2\u00b7\u00bd\u00c2\u00c8\u00cf\u00d1"+
		"\u00d7\u00d9\u00e4\u00ed\u00f2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}