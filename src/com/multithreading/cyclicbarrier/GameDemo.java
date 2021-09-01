package com.multithreading.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class GameDemo {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(5);
		Player p1 = new Player("p1",3200,barrier);
		Player p2 = new Player("p2",5000,barrier);
		Player p3 = new Player("p3",9000,barrier);
		Player p4 = new Player("p4",12000,barrier);
		Player p5 = new Player("p5",14000,barrier);
		
		Player p6 = new Player("p6",10000,barrier);
		Player p7 = new Player("p7",11000,barrier);
		Player p8 = new Player("p8",1000,barrier);
		Player p9 = new Player("p9",2000,barrier);
		Player p10 = new Player("p10",6000,barrier);
		
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
	}

}
