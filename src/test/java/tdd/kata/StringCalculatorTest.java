package tdd.kata;

import static org.junit.Assert.assertEquals;

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
	
	@Test 
	public void shouldReturnSumForNewLineDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2\n3"));
    }
	
	@Test 
	public void shouldReturnSumForNewLineAndCommaDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }
	
	@Test 
	public void shouldReturnSumForCustomDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
	
	@Test 
	public void shouldReturnSumForCustomDelimiterAndThreeNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("//;\n1;2;3"));
    }
	
	@Test 
	public void shouldReturnSumForSpaceDelimiterAndThreeNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10, stringCalculator.add("// \n1 2 3 4"));
    }
	
	@Test(expected = NegativeNumberException.class)
	public void shouldThrowExceptionForNegativeNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10, stringCalculator.add("-1\n2\n3"));
    }
	
	@Test(expected = NegativeNumberException.class)
	public void shouldThrowExceptionForNegativeNumberWithCustomDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10, stringCalculator.add("//;\n1;-2;3"));
    }
	
	@Test
	public void shouldThrowExceptionForNegativeNumberAndValidateMessage() {
        StringCalculator stringCalculator = new StringCalculator();
        try{
        	stringCalculator.add("-1,-2,-3");
        }
        catch (RuntimeException e) {
        	assertEquals("Negatives not allowed: -1,-2,-3", e.getMessage());
        }
    }

	@Test
	public void shouldReturnProperCountForSingleAdd() {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("1");
        assertEquals(1, stringCalculator.getCalledCount());
    }
	
	@Test
	public void shouldReturnProperCountOfMultipleAddCalls() {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("1");
        stringCalculator.add("2");
        assertEquals(2, stringCalculator.getCalledCount());
    }
	
	@Test
	public void shouldIgnoreNumbersGreaterThan1000() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("//;\n1;2000;1001"));
    }
	
	@Test
	public void shouldHonourDelimitersOfAnyLength() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }
	
	@Test
	public void shouldHonourDelimitersOfMultipleDelimiters() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }
	
	@Test
	public void shouldHonourDelimitersOfMultipleDelimitersOfAnyLength1() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));
    }
	
	@Test
	public void shouldHonourDelimitersOfMultipleDelimitersOfAnyLength2() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10, stringCalculator.add("//[*||*][%--%]\n1*||*2*||*3%--%4"));
    }
}