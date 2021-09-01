package com.multithreading.countdown;

import java.util.concurrent.CountDownLatch;

public class RaceDemo {
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(4);
		
		Participant p1 = new Participant(countDownLatch, "p1", 3000);
		Participant p2 = new Participant(countDownLatch, "p2", 5000);
		Participant p3 = new Participant(countDownLatch, "p3", 9000);
		Participant p4 = new Participant(countDownLatch, "p4", 12000);
		Participant p5 = new Participant(countDownLatch, "p5", 14000);
		
		Participant p6 = new Participant(countDownLatch, "p6", 10000);
		Participant p7 = new Participant(countDownLatch, "p7", 11000);
		Participant p8 = new Participant(countDownLatch, "p8", 2000);
		Participant p9 = new Participant(countDownLatch, "p9", 5000);
		Participant p10 = new Participant(countDownLatch, "p10", 6000);
//		Cheater c1 = new Cheater(countDownLatch,"c1",1000);
		
//		c1.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		
		p6.start();
		p7.start();
		p8.start();
		p9.start();
		p10.start();
		
		countDownLatch.await();
		
		System.out.println("RACE OVER");
		System.out.println("***THE WINNERS ARE***");
		Participant.displayWinners();
		System.out.println("***************");
	}
}
