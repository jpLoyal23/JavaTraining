package com.hlag.test;

public class LambdaExpressionsDemo1 {

	public static void main(String[] args) {
		Ipos ipos = (int a, int b) -> a + b;
		int res = ipos.add(20, 40);
		System.out.println(res);
		
		// add arqument also lambda
		demo((a, b) -> a + b + 10);

	}

	public static void demo(Ipos ipos) {
		System.out.println(ipos.add(10, 20));

	}
}


@FunctionalInterface
interface Ipos {
	public int add(int a, int b);

}