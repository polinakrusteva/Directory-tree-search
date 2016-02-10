package main;

import java.nio.file.Path;
import java.nio.file.Paths;

import implementation.Consumer;
import implementation.Producer;

public class Main {
	
	public static void main(String[] args) {
		Path path = Paths.get("/home/polinakk/Desktop/Google");
		Consumer.setKeyword("polokopr");
		Thread[] producers = new Thread[] { new Producer(path), new Producer(path), new Consumer() };
		
		for (Thread t : producers) {
			t.start();
		}
		
	}
	
}
