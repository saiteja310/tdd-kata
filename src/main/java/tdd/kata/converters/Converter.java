package tdd.kata.converters;

import java.util.Arrays;

public class Converter {
	
	public static int[] convertToInt(String[] numbers) {
		return Arrays.stream(numbers)
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}
