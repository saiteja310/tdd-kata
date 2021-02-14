package tdd.kata.validationRules;

import java.util.Collection;

public class NumberValidators {
	private Collection<ValidationRule> rules;

	public NumberValidators(Collection<ValidationRule> rules) {
        this.rules = rules;
    }
	
	public void validate(int[] integers) {
		rules.forEach(e -> e.validate(integers));
	}
}
