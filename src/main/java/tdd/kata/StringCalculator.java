package tdd.kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {
	public int add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		}
		
		IntStream integers = split(numbers);
		return integers.sum();
	}
	
	private IntStream split(String numbers) {
		String[] data = numbers.split(",");
		return convertToInt(data);
	}
	
	private IntStream convertToInt(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt);
	}
}