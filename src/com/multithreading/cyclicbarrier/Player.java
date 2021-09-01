package com.multithreading.cyclicbarrier;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player extends Thread {

	private static Set<Player> readyPlayers = new HashSet<Player>();
	private CyclicBarrier barrier;
	private String name;
	private boolean available = false; // by default player will not be available
	private int duration;

	public Player() {
	}

	public Player(String name, int duration, CyclicBarrier barrier) {
		super(name);
		this.name = name;
		this.duration = duration;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println(name + " has connected...."+"available "+available);
		try {
			Thread.sleep(duration);
			available = true;
			System.out.println(name + "is available");
			readyPlayers.add(this);
			int await = barrier.await();
			if(await == 0) {
				System.out.println("\n-----IN MATCH -----");
				readyPlayers.stream().forEach(x->{
						x.available=false;
						System.out.print(x.getName() + "");
						System.out.println();
					}
				);
				System.out.println();
				readyPlayers.clear();
			}
		}
		catch(InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
