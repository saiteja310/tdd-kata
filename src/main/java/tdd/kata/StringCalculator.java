package tdd.kata;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
	
	private String defaultDelimiterRegex = ",|\n";
	private int addCalledCount = 0;
	
	public int add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		}
		
		addCalledCount++;
		
		int[] integers = split(numbers);
		invalidateNegativeNumbers(integers);
		return IntStream
				.of(integers)
				.filter(e -> e < 1001)
				.sum();
	}
	
	public int getCalledCount() {
		return addCalledCount;
	}

	// Helper method to split the strings based on various types of delimiters
	private int[] split(String numbers) {
		
		String delimiterRegex = defaultDelimiterRegex;
		if(hasCustomDelimiter(numbers)) {
			String[] splitterArray = numbers.split("\n");
			delimiterRegex = splitterArray[0].substring(2);
			numbers = splitterArray[1];
		}
		
		String[] data = numbers.split(delimiterRegex);
		return convertToInt(data);
	}
	
	// Method to validate that Integer array doesn't contain any negative numbers.
	// Throws Exception if the array contains negative numbers
	private void invalidateNegativeNumbers(int[] integers) {
		int[] negativeNumbers = IntStream.of(integers).filter(e -> e < 0).toArray();
		if(negativeNumbers.length > 0) {
			throw new NegativeNumberException(negativeNumbers);
		}
	}
	
	// Helper method to validate if the string has custom delimiters
	private boolean hasCustomDelimiter(String numbers) {
		return numbers.startsWith("//");
	}

	// Helper method to convert String array to Integer array
	private int[] convertToInt(String[] numbers) {
		return Arrays.stream(numbers)
				.mapToInt(Integer::parseInt)
				.toArray();
	}

}

// Custom Exception when negative number arises
class NegativeNumberException extends RuntimeException {

	private static final long serialVersionUID = -5068468626860816079L;

	public NegativeNumberException(int[] array) {
		super("Negatives not allowed: " + IntStream.of(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));
	}
}