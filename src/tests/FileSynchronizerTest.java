package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import implementation.FileSynchronizer;

public class FileSynchronizerTest {

	private static final String TEST = "TEST";

	@Test
	public void testIsVisited() {
		String key = TEST;
		FileSynchronizer.getInstance().tryVisitFile(key);
		Boolean expectedValue = true;
		Boolean actualValue = FileSynchronizer.getInstance().isVisited(key);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testIsNotVisited() {
		String key = TEST;
		Boolean expectedValue = false;
		Boolean actualValue = FileSynchronizer.getInstance().isVisited(key);
		assertEquals(expectedValue,actualValue);
	}
	
}
