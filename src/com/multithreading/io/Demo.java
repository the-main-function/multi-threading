package com.multithreading.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Demo {
	public static void main(String[] args) throws IOException {
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream();
		Producer p = new Producer(pos);
		Consumer c = new Consumer(pis);
		pos.connect(pis);
		new Thread(p).start();
		new Thread(c).start();
	}
	
}
