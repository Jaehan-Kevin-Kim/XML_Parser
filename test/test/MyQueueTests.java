package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.ListADT;
import utilities.MyQueue;

/**
 * Doubly Linked List Test class
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 21, 2021
 */
public class MyQueueTests {
	
	private MyQueue<String> queue1;
	private MyQueue<String> queue2;
	private Object[] testArray;
	private utilities.Iterator<String> testIterator;
	
	/**
	 * @Before - Will execute the method before each test. 
	 * 		This method can prepare the test environment (e.g. read input data, initialize the class). 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		queue1 = new MyQueue<>();
		queue2 = new MyQueue<>();
	}

	/**
	 * @After - Will execute the method after each test. 
	 * 		This method can cleanup the test environment (e.g. delete temporary data, restore defaults). 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		queue1 = null;
		queue2 = null;
	}

	/**
	 * Test method for {@link ListADT.MyQueue#MyQueue()}.
	 * Constructs a Queue with the default capacity.
	 */
	@Test
	public void testMyQueue() {
		assertEquals(0, queue1.size());
		assertTrue(queue1.isEmpty());
	}

	/**
	 * Test method for {@link ListADT.MyQueue#size()}.
	 * The size method will return the current element count contained 
	 * in the list.
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(0, queue1.size());
	}
	
	/**
	 * Test method for {@link ListADT.MyQueue#size()}.
	 * The size method will return the current element count contained 
	 * in the list.
	 */
	@Test
	public void testSizeNotEmpty() {
		queue1.enqueue("A");
		assertEquals(1, queue1.size());
	}

	/**
	 * Test method for {@link ListADT.MyQueue#enqueue()}.
	 * Puts the element E to the tail of the queue.
	 */
	@Test
	public void testEnqueue() {
		queue1.enqueue("A");
		queue1.enqueue("B");
		queue1.enqueue("C");
		assertEquals(3, queue1.size());
		assertFalse(queue1.isEmpty());
	}

	/**
	 * Test method for {@link ListADT.MyQueue#dequeue()}.
	 * Takes the top element of the queue.
	 */
	@Test
	public void testDequeue() {
		try {
			queue1.enqueue("A");
			queue1.enqueue("B");
			queue1.enqueue("C");
			assertEquals("A", queue1.dequeue());
			assertEquals("B", queue1.dequeue());
			assertEquals("C", queue1.dequeue());
			assertEquals(0, queue1.size());
			assertTrue(queue1.isEmpty());
		} catch (IndexOutOfBoundsException e){

			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyQueue#peek()}.
	 * Returns the topmost element in the stack without removing it.
	 */
	@Test
	public void testPeek() {
		try {
			queue1.enqueue("A");
			queue1.enqueue("B");
			queue1.enqueue("C");
			assertEquals("A", queue1.peek());
			queue1.dequeue();
			assertEquals("B", queue1.peek());
			queue1.dequeue();
			assertEquals("C", queue1.peek());
		} catch (IndexOutOfBoundsException e){

			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyQueue#isEmpty()}.
	 * Tests if the queue is empty.
	 */
	@Test
	public void testIsEmpty() {
		queue1.dequeueAll();
		assertTrue(queue1.isEmpty());
	}

	/**
	 * Test method for {@link ListADT.MyQueue#isFull()}.
	 * Tests if the queue is of static capacity.
	 */
	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
		queue1.enqueue("A");
		assertTrue(queue1.isFull());
	}

	/**
	 * Test method for {@link ListADT.MyQueue#dequeueAll()}.
	 * Removes all items from this queue.
	 */
	@Test
	public void testDequeueAll() {
		queue1.dequeueAll();
		assertTrue(queue1.isEmpty());
	}

	/**
	 * Test method for {@link ListADT.MyQueue#equals(QueueADT<E>)}.
	 * Verify if two queues the same order and same items.
	 */
	@Test
	public void testEqualsQueueADTOfE() {
		try {
			queue1.enqueue("A");
			queue1.enqueue("B");
			queue1.enqueue("C");
			queue2.enqueue("A");
			queue2.enqueue("B");
			queue2.enqueue("C");
			assertTrue(queue1.equals(queue2));
			queue2.enqueue("D");
			assertFalse(queue1.equals(queue2));
			assertFalse(queue2.equals(queue1));
		} catch (IndexOutOfBoundsException e){

			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyQueue#toArray(E[])}.
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence.
	 */
	@Test
	public void testToArrayEArray() {
		queue1.enqueue("A");
		queue1.enqueue("B");
		queue1.enqueue("C");
		String[] testArray2 = {"A","B","C"};
		testArray = queue2.toArray(testArray2);
		assertEquals("A", testArray[0]);
		assertEquals("B", testArray[1]);
		assertEquals("C", testArray[2]);
	}

	/**
	 * Test method for {@link ListADT.MyQueue#toArray()}.
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence.
	 */
	@Test
	public void testToArray() {
		queue1.enqueue("A");
		queue1.enqueue("B");
		queue1.enqueue("C");
		testArray = queue1.toArray();
		assertEquals("A", testArray[0]);
		assertEquals("B", testArray[1]);
		assertEquals("C", testArray[2]);
	}

	/**
	 * Test method for {@link ListADT.MyQueue#iterator()}.
	 * Returns an iterator over the elements in this list, in proper sequence.
	 */
	@Test
	public void testIterator() {
		queue1.enqueue("A");
		queue1.enqueue("B");
		queue1.enqueue("C");
		testIterator = queue1.iterator();
		assertTrue(testIterator.hasNext());
		assertEquals("A", testIterator.next());
		assertTrue(testIterator.hasNext());
		assertEquals("B", testIterator.next());
		assertTrue(testIterator.hasNext());
		assertEquals("C", testIterator.next());
		assertFalse(testIterator.hasNext());
	}
}