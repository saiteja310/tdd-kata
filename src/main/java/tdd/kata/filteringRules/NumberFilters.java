package tdd.kata.filteringRules;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class NumberFilters {
	private Collection<IntPredicate> rules;

	public NumberFilters(Collection<IntPredicate> rules) {
        this.rules = rules;
    }
	
	public IntStream filter(IntStream stream) {
		Iterator<IntPredicate> it = rules.iterator();
		while(it.hasNext()){
			stream = stream.filter(it.next());
		}
		return stream;
	}
}
