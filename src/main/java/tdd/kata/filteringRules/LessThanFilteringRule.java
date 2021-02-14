package tdd.kata.filteringRules;

import java.util.function.IntPredicate;

public class LessThanFilteringRule implements IntPredicate {
	
	private final int value;

	public LessThanFilteringRule(int value) {
        this.value = value;
    }
	
	@Override
	public boolean test(int e) {
		return e < value;
	}
}
