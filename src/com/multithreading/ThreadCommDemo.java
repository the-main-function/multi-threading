package com.multithreading;

class User{
	int balance = 100;
	
	public synchronized void withdrawAmount(int amount) {
		System.out.println("user is wishing to withdraw " + amount);
		if(amount>balance) {
			System.out.println("balance insufficient.. waiting for deposit");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		balance = balance - amount;
		System.out.println("amount withdrawal successful ::" + "balance ::"+balance);
	}
	
	public synchronized void depositAmount(int amount) {
		System.out.println("amount is being deposited "+amount);
		balance += amount;
		notify();
	}
}


public class ThreadCommDemo {

	public static void main(String[] args) {
		 
		User u1 = new User();
		Runnable r1 = () -> {u1.withdrawAmount(500);};
		Runnable r2 = () -> {u1.depositAmount(600);};
		new Thread(r1).start();
		new Thread(r2).start();
	}

}
