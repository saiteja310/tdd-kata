package tdd.kata.tokenizers;

public class DefaultTokenizer implements Tokenizer {

	private String defaultDelimiterRegex = ",|\n";
	
	@Override
	public String[] tokenize(String token) {
		return token.split(defaultDelimiterRegex);
	}
}
