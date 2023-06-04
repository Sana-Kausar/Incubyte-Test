package com.sanakausar.SpringCalculator;

import java.util.ArrayList;

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
}
