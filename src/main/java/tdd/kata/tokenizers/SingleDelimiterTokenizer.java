package tdd.kata.tokenizers;

public class SingleDelimiterTokenizer implements Tokenizer {

	@Override
	public String[] tokenize(String token) {
		String[] splitterArray = token.split("\n");
		
		String delimiterRegex = splitterArray[0].substring(2);
		String numbers = splitterArray[1];
		
		return numbers.split(delimiterRegex);
	}

}
