package com.sanakausar.SpringCalculator;

public class Calculator {

	public static int add(String numbers) {
		String[] num=splitNumbers(numbers);
		int size=num.length;
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
}
