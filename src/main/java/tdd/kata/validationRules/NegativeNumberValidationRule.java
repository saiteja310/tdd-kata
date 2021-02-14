package tdd.kata.validationRules;

import java.util.stream.IntStream;

import tdd.kata.exceptions.NegativeNumberException;

public class NegativeNumberValidationRule implements ValidationRule {

	@Override
	public void validate(int[] integers) {
		int[] negativeNumbers = IntStream.of(integers).filter(e -> e < 0).toArray();
		if(negativeNumbers.length > 0) {
			throw new NegativeNumberException(negativeNumbers);
		}
	}

}
