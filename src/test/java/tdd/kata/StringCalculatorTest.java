package tdd.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test 
	public void emptyStringShouldReturn0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }
	
	@Test 
	public void shouldReturnSumForOneNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
	
	@Test 
	public void shouldReturnSumForTwoNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }
	
	@Test 
	public void shouldReturnSumForAnyNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1,2,3"));
    }
	
}