package com.hlag.training;

import java.util.function.Function;

public class FunctionalInterfaceTesting {

	public static void main(String[] args) {

		Function<Integer, String> fun = (a) -> {
		if (a % 7 == 0) {
			return "" + true;
		} else {
			return "" + false;
		}
	};

	System.out.println(fun.apply(7));
	Function<String, Integer> function = x -> x.length();

	Function<Integer, Integer> function1 = x -> x *2;

	int result = function.andThen(function1).apply("jai");
	System.out.println(result);
	
	
	

}
}
