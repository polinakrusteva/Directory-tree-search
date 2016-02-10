package implementation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileSynchronizer {

	public static synchronized FileSynchronizer getInstance() {
		if (null == instance) {
			instance = new FileSynchronizer();
		}
		return instance;
	}
	
	private static FileSynchronizer instance = new FileSynchronizer();
	
	private Map<String, Boolean> visitedFiles;
	
	private FileSynchronizer() {
		visitedFiles = new ConcurrentHashMap<>();
	}
	
	public boolean isVisited(String name) {
		if (null == visitedFiles.get(name)) {
			return false;
		}
		return true;
	}
	
	public synchronized boolean tryVisitFile(String name) {
		if (isVisited(name)) { 
			return false;
		}
		//System.out.println(String.format("Adding %s to visited - %s", name, Thread.currentThread().getName()));
		visitedFiles.put(name, true);
		return true;
	}
}
