package com.multithreading;

class ChildThread1 extends Thread{

	
	
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("start method called");
	}

	@Override
	public void run() {
		System.out.println("run method called");
		for(int i = 1; i<=1000;i++) {
			System.out.println("CHILD THREAD RUNNING"+ getName());
		}
	}
}

public class ThreadDemo1{
	public static void main(String[] args) {
	
		Thread t = new ChildThread1();
		
		t.start();
		for(int i = 1; i<=1000;i++) {
			System.out.println("MAIN THREAD RUNNING");
		}
	}
	
}
