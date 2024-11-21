package com.hlag.training;

import java.util.stream.IntStream;

public class ThreadDemo {

	public static void main(String[] args) {
		Runnable run = () -> {

			IntStream.range(1, 10).forEach((e) -> {
				try {
					Thread.sleep(1000);
					System.out.println(e + Thread.currentThread().getName());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			});

		};
		Thread t = new Thread(run);
		t.setName("Thread-1-jp1::");
		t.setPriority(3);
		try {
			t.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t.start();
		Thread t2 = new Thread(run);
		t.setName("Thread-2-jp2::");
		t.setPriority(10);
		try {
			t2.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t2.start();
		Thread t3 = new Thread(run);
		t.setName("Thread-3-jp3::");
		t.setPriority(2);
		try {
			t3.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t3.start();

		Thread.getAllStackTraces().forEach((k, v) -> {
			if (k.getThreadGroup().getName().equals("main")) {
				System.out.println(k);
			}
		});
	}

}
