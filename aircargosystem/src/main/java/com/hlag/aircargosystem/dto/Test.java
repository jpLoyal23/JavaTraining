package com.hlag.aircargosystem.dto;

public class Test {

	public static void main(String[] args) {

		Test.birdFly(new IronMan());
		Flyable flyable = new IronMan();
		flyable.fly();
	}

	public static void birdFly(Flyable f) {
		f.fly();
	}

}
