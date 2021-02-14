package tdd.kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {
	
	private String DefaultDelimiterRegex = ",|\n";
	
	public int add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		}
		
		IntStream integers = split(numbers);
		return integers.sum();
	}
	
	// Helper method to split the strings based on various types of delimiters
	private IntStream split(String numbers) {
		
		String delimiterRegex = DefaultDelimiterRegex;
		if(hasCustomDelimiter(numbers)) {
			String[] splitterArray = numbers.split("\n");
			delimiterRegex = splitterArray[0].substring(2);
			numbers = splitterArray[1];
		}
		
		String[] data = numbers.split(delimiterRegex);
		return convertToInt(data);
	}
	
	// Helper method to validate if the string has custom delimiters
	private boolean hasCustomDelimiter(String numbers) {
		return numbers.startsWith("//");
	}

	// Helper method to convert String array to IntStream
	private IntStream convertToInt(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt);
	}
}