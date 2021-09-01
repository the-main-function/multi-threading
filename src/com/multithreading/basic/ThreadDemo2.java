package com.multithreading.basic;


public class ThreadDemo2{
	public static void main(String[] args) {
	
		Runnable r = () -> {
								for(int i = 1;i<1000;i++) {
									System.out.println("CHILD THREAD");
								}
							};
		
		new Thread(r).start();
		for(int i = 1; i<=1000;i++) {
			System.out.println("MAIN THREAD RUNNING");
		}
	}
	
}
