package com.gk.lambda.threaddemo;

public class ThreadDemo {

	public static void main(String[] args) {

		Runnable r = () -> {
			try {
				for (int i = 1; i < 10; i++) {
					System.out.print(i * 2 + " ");
					Thread.sleep(2000);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		};

		Thread t2 = new Thread(r);
		t2.setName("Mick");
		t2.start();

	}

}
