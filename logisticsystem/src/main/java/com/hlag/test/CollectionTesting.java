package com.hlag.test;


public class CollectionTesting {

	public static void main(String[] args) {
		// I1 i1 = new Hello();
		// boolean reult = i1.test();
		// i1.test2();

		I1 i2 = () -> {
			System.out.println("hello from lambda");
		};
		i2.test();
		i2.test2();
//
//		I1 i1 = new I1() {
//
//			@Override
//			public boolean test() {
//				return true;
//			}

			// @Override
			// public void test2() {
			// System.out.println("hello from overriden");
			// }
			// };
			// i1.test2();
	}

}

@FunctionalInterface
interface I1 {

	public void test();

	public default void test2() {
		System.out.println("hello from test2");
	}
}
//
// class Hello implements I1 {
//
//	@Override
//	public boolean test() {
//		System.out.println("hello from test");
//		return true;
//
//	}
//
// @Override
// public void test2() {
// // I1.super.test2();
// System.out.println("test 2 is overrriden");
// }
// }
