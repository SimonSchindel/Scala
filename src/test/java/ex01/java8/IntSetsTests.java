package ex01.java8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntSetsTests {

	private IntSet testSet;
	
	@Before
	public void setUp() throws Exception {
		testSet = new Empty().incl(1).incl(2).incl(3).incl(4);
	}

	@Test
	public void testEmpty() {
		for (int i = -1000; i <= 1000; i++)
			assertFalse(new Empty().contains(i));
	}

	@Test
	public void testOneElementSet() {
		for (int i = -1000; i <= 1000; i++) 
			assertTrue(new Empty().incl(i).contains(i));
	}
	
	@Test
	public void testSetContains2() {
		assertTrue(testSet.contains(2));
	}
	
	@Test
	public void testFilter() {
		assertTrue(testSet.filter((i) -> i < 2).contains(1));
		assertFalse(testSet.filter((i) -> i < 2).contains(3));
	}
}
