package test;

import static org.junit.Assert.*;

import java.util.*;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.*;

/**
 * Doubly Linked List Test class
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 21, 2021
 */
public class MyStackTests {

	MyStack<String> stack1;
	MyStack<String> stack2;
	Object[] testArray;
	utilities.Iterator<String> testIterator;
	
	@Before
	public void setUp() throws Exception {
		stack1 = new MyStack<>();
		stack2 = new MyStack<>();
	}

	@After
	public void tearDown() throws Exception {
		stack1 = null;
		stack2 = null;
	}

	@Test
	public void testMyStack() {
		assertEquals(0, stack1.size());
		assertTrue(stack1.isEmpty());
	}

	@Test
	public void testMyStackInt() {
		assertEquals(0, stack2.size());
		assertTrue(stack2.isEmpty());
	}

	@Test
	public void testSizeEmpty() {
		assertEquals(0, stack1.size());
	}
	
	@Test
	public void testSizeNotEmpty() {
		stack1.push("A");
		assertEquals(1, stack1.size());
	}

	@Test
	public void testPush() {
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		assertEquals(3, stack1.size());
		assertFalse(stack1.isEmpty());
	}
	
	@Test
	public void testPop() {
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		assertEquals("C", stack1.pop());
		assertEquals("B", stack1.pop());
		assertEquals("A", stack1.pop());
		assertEquals(0, stack1.size());
		assertTrue(stack1.isEmpty());
	}

	@Test
	public void testPeek() {
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		assertEquals("C", stack1.peek());
		stack1.pop();
		assertEquals("B", stack1.peek());
		stack1.pop();
		assertEquals("A", stack1.peek());
	}

	@Test
	public void testSearch() {
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		assertEquals(1, stack1.search("A"));
		assertEquals(2, stack1.search("B"));
		assertEquals(-1, stack1.search("D"));
	}

	@Test
	public void testRemoveAll() {
		stack1.removeAll();
		assertTrue(stack1.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		stack1.push("A");
		assertFalse(stack1.isEmpty());
		stack1.pop();
		assertTrue(stack1.isEmpty());
	}

	@Test
	public void testToArrayEArray() {
		
		String[] testArray2 = {"A","B","C"};
		testArray = stack2.toArray(testArray2);
		assertEquals("A", testArray[0]);
		assertEquals("B", testArray[1]);
		assertEquals("C", testArray[2]);
	}

	@Test
	public void testToArray() {
		
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		testArray = stack1.toArray();
		assertEquals("A", testArray[0]);
		assertEquals("B", testArray[1]);
		assertEquals("C", testArray[2]);
	}

	@Test
	public void testIterator() {
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		
		testIterator =  stack1.iterator();
		
		while (testIterator.hasNext()) {
			assertEquals("A", testIterator.next());
			assertEquals("B", testIterator.next());
			assertEquals("C", testIterator.next());
		}

	}
}