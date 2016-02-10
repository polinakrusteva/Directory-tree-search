package main;

import java.nio.file.Path;
import java.nio.file.Paths;

import implementation.Consumer;
import implementation.Producer;

public class Main {
	
	public static void main(String[] args) {
		Path path = Paths.get("/home/polinakk/Desktop/Test");
		Consumer.setKeyword("poli");
		Thread producer = new Producer(path);
		Thread consumer = new Consumer();
		
		producer.start();
		consumer.start();
		
	}
	
}
