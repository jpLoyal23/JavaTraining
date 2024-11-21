package com.hlag.test;

public class LambdaTest {

	public static void main(String[] args) {
		
		test((a) -> {
			if( a % 7 ==0) {
				return true;
			}
			else {
			return false;
			}
		});
	}

	public static void test(Test t) {
		boolean result = t.divide(14);
		System.out.println(result);

	}

}

@FunctionalInterface
interface Test {
	boolean divide(int a);

}