package com.hlag.training;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
				new Product("Laptop", 1200),
				new Product("Mouse", 20),
				new Product("Keyboard", 50),
				new Product("Monitor", 200),
				new Product("Charger", 30));

		// Custom Collector
		Map<String, Double> priceRangeTotals = products.stream().collect(Collectors.groupingBy(p -> {
			if (p.getPrice() < 50) {
				return "<50:";
			} else if (p.getPrice() < 200) {
				return "50-100:";
			} else {
				return ">100:";
			}
		},
				Collector.of(
						() -> new double[1], // supplier
						(a, b) -> a[0] += b.getPrice(), // accumulator
						(a1, a2) -> {
							a1[0] += a2[0]; // combiner
							return a1;
						},
						a -> a[0]))); // finisher

		priceRangeTotals.forEach((a, b) -> System.out.println("key->" + a + ", value->" + b));

		System.out.println("Total value by price range: " + priceRangeTotals);
	}


}
