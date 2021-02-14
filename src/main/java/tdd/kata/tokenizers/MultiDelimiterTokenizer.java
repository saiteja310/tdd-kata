package tdd.kata.tokenizers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MultiDelimiterTokenizer implements Tokenizer {

	@Override
	public String[] tokenize(String token) {
		String[] splitterArray = token.split("\n");
		
		String delimiterRegex = splitterArray[0].substring(2);
		String numbers = splitterArray[1];
		
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(delimiterRegex);
		List<String> matches = new ArrayList<>();
		
		while(m.find()) {
			matches.add(escapeSpecialCharacters(m.group(1)));
		}
		
		String regex = matches.stream().collect(Collectors.joining("|"));
		
		return numbers.split(regex);
	}
	
	private String escapeSpecialCharacters(String s) {
	    return s.replaceAll("[\\W]", "\\\\$0");
	}

}
