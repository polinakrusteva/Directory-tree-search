package implementation;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileManipulator extends SimpleFileVisitor<Path> {

	public void readLines(File file) throws FileNotFoundException, IOException {
		String line;
		long row = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				row++;
				ProductFactory.getInstance().add(new LineDTO(file.getName(), row, line));
			}
		}
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws FileNotFoundException, IOException {
		if (FileSynchronizer.getInstance().tryVisitFile(file.getFileName().toString())) {
			readLines(file.toFile());
		}
		return CONTINUE;
	}
}
