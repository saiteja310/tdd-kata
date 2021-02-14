package tdd.kata.exceptions;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NegativeNumberException extends RuntimeException {

	private static final long serialVersionUID = -5068468626860816079L;

	public NegativeNumberException(int[] array) {
		super("Negatives not allowed: " + IntStream.of(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));
	}
}