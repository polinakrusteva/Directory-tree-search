package implementation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Producer extends Thread {

	private FileManipulator visitor = new FileManipulator();
	private Path start;

	public Producer(Path path) {
		this.start = path;
	}

	@Override
	public void run() {
		try {
			Files.walkFileTree(start, visitor);
			ProductFactory.getInstance().setFinished();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
