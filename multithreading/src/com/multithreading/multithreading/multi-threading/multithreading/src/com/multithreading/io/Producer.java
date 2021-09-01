package com.multithreading.io;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.*;

public class Producer implements Runnable{
	
	PipedOutputStream os;
	
	Producer(PipedOutputStream os){
		this.os = os;
	}
	
	public void sendData() throws IOException {
		
		String someText = "HELLO";
		byte[] byteText = someText.getBytes();
		
//		for(int i=1;i<10;i++) {
//			os.write(i*5);
//		}
				
		os.write(byteText);
		os.close();
		
	}

	@Override
	public void run() {
		System.out.println("sending data");
		try {
			sendData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
