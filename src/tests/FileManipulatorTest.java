package tests;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import implementation.FileManipulator;

public class FileManipulatorTest {

	private static FileManipulator manipulator;
	
	@BeforeClass
	public static void initClass() {
		manipulator = new FileManipulator();
	}
	
	@Test(expected = IOException.class)
	public void testFileNotFoundException() throws IOException{
		manipulator.readLines(new MockFile());
	}
	
	class MockFile extends File {
		
		public MockFile() {
			super("TEST");
		}

		@Override
		public boolean canRead() {
			return false;
		}

		@Override
		public boolean canWrite() {
			return false;
		}
	}

}
