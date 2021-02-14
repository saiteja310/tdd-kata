package tdd.kata.tokenizers;

public class TokenizerFactory {

	TokenizerFactory() {}
	
	public static Tokenizer createTokenizer(String token) {
		if(hasCustomDelimiter(token) && areMultipleDelimiters(token))
			return new MultiDelimiterTokenizer();
		else if(hasCustomDelimiter(token))
			return new SingleDelimiterTokenizer();
		return new DefaultTokenizer();
	}
	
	private static boolean hasCustomDelimiter(String token) {
		return token.startsWith("//");
	}
	
	private static boolean areMultipleDelimiters(String delimiterRegex) {
		return delimiterRegex.contains("[") && delimiterRegex.contains("]");
	}
}
