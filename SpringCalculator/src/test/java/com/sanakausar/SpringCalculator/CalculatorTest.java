package com.sanakausar.SpringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
	
	//for empty string return zero
    
  @Test
  public void emptyStringCheck() {
    assertEquals(0, Calculator.add(""));
  }
  
  //for single number return same number
  
  @Test
  public void singleNumberCheck() {
	  assertEquals(10, Calculator.add("10"));
  }
  
  //for two numbers separated by commas returns the sum
  
  @Test
  public void twoNumCommmaSeparatedCheck() {
	  assertEquals(6, Calculator.add("2,4"));
  }
  
  //for multiple numbers returns sum of all
  
  @Test
  public void multipleNumCommaSeparatedCheck() {
	  assertEquals(6, Calculator.add("1,2,3"));
  }
  
  //allow new line delimiter
  
  @Test
  public void newLineDelimiterCheck() {
	  assertEquals(6, Calculator.add("1,2\n3"));
  }
  
  //should throw exception with list of negative numbers if given
  
  @Test
  public void negativeNumbersCheck() {
	  try {
		  Calculator.add("1,-2,-3");
	  }catch(RuntimeException e) {
		  assertEquals("Negative numbers are not allowed: -2,-3", e.getMessage());
	  }
  }
}
