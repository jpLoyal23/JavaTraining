package com.hlag.training;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HashMapTest {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);
		map.put("F", 60);

		map.forEach((k, v) -> {
			System.out.println(k + " :" + v);
		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key :" + entry.getKey() + ",value:" + entry.getValue());
		}

		Function<String, Integer> function = x -> x.length();
		System.out.println(function.apply("jai"));

	}

}
