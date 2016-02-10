package main;

import java.nio.file.Path;
import java.nio.file.Paths;

import implementation.Consumer;
import implementation.Producer;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Path path = Paths.get("/home/polinakk/Desktop/Test");
		Consumer.setKeyword("Integer");
		
		int numberProducers = 3;
		int numberConsumers = 3;
		
		Thread[] producers = new Thread[numberProducers];
		Thread[] consumers = new Thread[numberConsumers];
		
		for(int i = 0; i < numberConsumers; i++) {
			producers[i] = new Producer(path);
		}
		
		for(int i = 0; i < numberConsumers; i++) {
			consumers[i] = new Consumer();
		}
		
		for(Thread producer : producers) {
			producer.start();
		}
		
		for(Thread consumer : consumers) {
			consumer.start();
		}
		
		for(Thread producer : producers) {
			producer.join();
		}
		
		for(Thread consumer : consumers) {
			consumer.join();
		}
	}
	
}
