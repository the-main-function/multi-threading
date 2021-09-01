package com.multithreading.io;

import java.io.IOException;
import java.io.PipedInputStream;

public class Consumer implements Runnable{
	
	PipedInputStream is;
	
	public Consumer(PipedInputStream is){
		this.is = is;
	}
	
	public void readData() throws IOException {
		
		System.out.println("READING DATA");
//		for(int i=1;i<10;i++) {
//			System.out.println(is.read());
//	}
		byte[] textBytes = is.readAllBytes();
		String readString = new String(textBytes);
		System.out.println(readString);
		is.close();
		
	}

	@Override
	public void run() {
		try {
			readData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
