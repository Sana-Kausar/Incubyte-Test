package com.sanakausar.SpringCalculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String numbers) {
		String[] num=splitNumbers(numbers);
		int size=num.length;
		checkForNegatives(num);
		return findSum(num,size);
		}
	
	private static String[] splitNumbers(String numbers) {
		if(numbers.isEmpty()) {
			return new String[0];
		}else if(numbers.startsWith("//")) {
			return customDelimiterSplit(numbers);
		}
		String[] num=numbers.split(",|\n");
		return num;
	}
	
	private static int findSum(String[] num,int size) {
		int sum=0;
		for(int ind=0;ind<size;ind++) {
			sum=sum+ Integer.parseInt(num[ind]);
		}
		return sum;
	}
	
	private static void checkForNegatives(String[] numbers) {
		ArrayList<String> neg=new ArrayList<String>();
		for(String num: numbers) {
			if(Integer.parseInt(num)<0) {
				neg.add(num);
			}
		}
		if(neg.size()>0) {
			throw new RuntimeException("Negative numbers are not allowed: " + String.join(",", neg));
		}
	}
	
	private static String[] customDelimiterSplit(String numbers){
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
		m.matches();
		String customDelimiter=m.group(1);
		String num=m.group(2);
		return num.split(Pattern.quote(customDelimiter));
	}
}
