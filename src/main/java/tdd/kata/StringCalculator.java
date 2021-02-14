package tdd.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import tdd.kata.converters.Converter;
import tdd.kata.filteringRules.LessThanFilteringRule;
import tdd.kata.filteringRules.NumberFilters;
import tdd.kata.tokenizers.Tokenizer;
import tdd.kata.tokenizers.TokenizerFactory;
import tdd.kata.validationRules.NegativeNumberValidationRule;
import tdd.kata.validationRules.NumberValidators;
import tdd.kata.validationRules.ValidationRule;

public class StringCalculator {
	
	private int addCalledCount = 0;
	
	private NumberFilters numberFilters;
	private NumberValidators numberValidators;
	
	public StringCalculator() {
		setUpFilteringRules();
		setUpValidationRules();
	}

	public int add(String numbers) {
		addCalledCount++;
		
		if(numbers.isEmpty()) {
			return 0;
		}
		
		int[] integers = tokenize(numbers);
		numberValidators.validate(integers);
		
		IntStream stream = IntStream.of(integers);
		return numberFilters.filter(stream).sum();
		
	}

	// Helper method to split the strings based on various types of delimiters
	private int[] tokenize(String token) {
		Tokenizer tokenizer = TokenizerFactory.createTokenizer(token);
		
		String[] data = tokenizer.tokenize(token);
		return Converter.convertToInt(data);
	}
	
	// Returns number of times Add Method has been called
	public int getCalledCount() {
		return addCalledCount;
	}
	
	private void setUpFilteringRules() {
		IntPredicate lessThanFilteringRule = new LessThanFilteringRule(1001);
		List<IntPredicate> filteringRules = new ArrayList<>();
		filteringRules.add(lessThanFilteringRule);
		numberFilters = new NumberFilters(filteringRules);
	}
	
	private void setUpValidationRules() {
		ValidationRule negativeNumberValidationRule = new NegativeNumberValidationRule();
		List<ValidationRule> validationRules = new ArrayList<>();
		validationRules.add(negativeNumberValidationRule);
		numberValidators = new NumberValidators(validationRules);
	}
	
}