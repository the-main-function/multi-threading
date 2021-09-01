package com.multithreading.countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Participant extends Thread {

	private CountDownLatch countDownLatch;
	private String name;
	private int duration;
	
	private static List<String> positionHolders = new ArrayList<String>();
	
	public Participant(CountDownLatch countDownLatch, String name, int duration) {
		this.countDownLatch = countDownLatch;
		this.name = name;
		this.duration = duration;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("PARTICIPANT :: " +name+ " has started running");
		
		try {
			Thread.sleep(duration);
			System.out.println("Particpant :: "+ name+" has completed his run");
			countDownLatch.countDown();
			positionHolders.add(name);
			
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void displayWinners() {
		positionHolders.stream().limit(4).forEach(x->System.out.println(x));
	}
}
