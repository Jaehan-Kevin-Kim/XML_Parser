package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.*;

/**
 * ArrayList Test class
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 21, 2021
 */
public class MyArrayListTests {

	MyArrayList<String> list1;
	MyArrayList<String> list2;
	
	/**
	 * @Before - Will execute the method before each test. 
	 * 		This method can prepare the test environment (e.g. read input data, initialize the class). 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		list1 = new MyArrayList<>();
		list2 = new MyArrayList<>(10);
	}

	/**
	 * @After - Will execute the method after each test. 
	 * 		This method can cleanup the test environment (e.g. delete temporary data, restore defaults). 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		list1=null;
		list2=null;
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#MyArrayList()}.
	 * Constructs an ArrayList with the default capacity
	 */
	@Test
	public void testMyArrayList() {
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#MyArrayList(int)}.
	 * Constructs an ArrayList with the specified capacity
	 */
	@Test
	public void testMyArrayListInt() {
		assertEquals(0, list2.size());
		assertTrue(list2.isEmpty());
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#size()}.
	 * Constructs an ArrayList with the specified capacity
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(0, list1.size());
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#size()}.
	 * Constructs an ArrayList with the specified capacity
	 */
	@Test
	public void testSizeNotEmpty() {
		list1.add("A");
		assertEquals(1, list1.size());
		
	}
	
	/**
	 * Test method for {@link ListADT.MyArrayList#clear()}.
	 * Removes all of the elements from this list
	 */
	@Test
	public void testClearEmpty() {
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	
	/**
	 * Test method for {@link ListADT.MyArrayList#clear()}.
	 * Removes all of the elements from this list
	 */
	@Test
	public void testClearNotEmpty() {
		list1.add("B");
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#add(int, E)}.
	 * Inserts the specified element at the specified position in this list.
	 */
	@Test
	public void testAddIntEEmpty() 
	{
		
		list1.add(0, "A");
		assertEquals(1, list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A", list1.get(0));
	}
	
	/**
	 * Test method for {@link ListADT.MyArrayList#add(int, E)}.
	 * Inserts the specified element at the specified position in this list.
	 */
	@Test
	public void testAddIntENotEmpty() {
		
	list1.add("B");
	list1.add(0, "A");
	assertEquals(2, list1.size());
	assertTrue(list1.contains("A"));
	assertEquals("A", list1.get(0));
	}
	
	/**
	 * Test method for {@link ListADT.MyArrayList#add(int, E)}.
	 * Inserts the specified element at the specified position in this list.
	 */
	@Test
	public void testAddIntELowerBound() {
		
		try 
		{
			list1.add(-1, "A");
			fail("No IndexOutOfBoundsException ");
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListADT.MyArrayList#add(int, E)}.
	 * Inserts the specified element at the specified position in this list.
	 */
	@Test
	public void testAddIntEUpperBound() {
		try 
		{
			list1.add(2, "A");
			fail("No IndexOutOfBoundsException ");
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
		
	}
	
	/**
	 * Test method for {@link ListADT.MyArrayList#add(int, E)}.
	 * Inserts the specified element at the specified position in this list.
	 */
	@Test
	public void testAddIntENull() {
		try 
		{
			list1.add(0, null);
			fail("No NullPointerException thrown");
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
		
	
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#add(E)}.
	 * Appends the specified element to the end of this list.
	 */
	@Test
	public void testAddE() {
		try
		{
			list1.add("e");
			assertEquals(1, list1.size());
			assertTrue(list1.contains("e"));			
			assertEquals("e", list1.get(0));
			
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#addAll(ListADT<? extends E>)}.
	 * Appends all of the elements of the specified collection to the end of this DLL.
	 */
	@Test
	public void testAddAll() {
		
		try {
		list1.add("a");
		list1.add("b");
		list1.add("cd");
		list2.add("e");
		list2.add("f");
		list2.add("gh");
		list1.addAll(list2);
		assertEquals(6, list1.size());
		assertTrue(list1.contains("cd"));
		assertTrue(list1.contains("e"));
		assertTrue(list1.contains("f"));
		assertTrue(list1.contains("gh"));
		assertEquals("gh", list1.get(5));
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#get(int)}.
	 * Returns the element at the specified position in this list.
	 */
	@Test
	public void testGet() {
		try {
		list1.add("a");
		list1.add("b");
		list1.add("cd");
		
		assertEquals(3, list1.size());
		assertEquals("a", list1.get(0));
		assertEquals("cd", list1.get(2));
		}
		catch (IndexOutOfBoundsException e){
			
			assertTrue(true);
			
		}
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#remove(int)}.
	 * Removes the element at the specified position in this list.
	 */
	@Test
	public void testRemoveInt() {
		try {
			list1.add("a");
			list1.add("b");
			list1.add("cd");
			assertEquals(3, list1.size());
			assertEquals("a", list1.get(0));
			assertEquals("b", list1.get(1));
			assertEquals("cd", list1.get(2));
			list1.remove(1);
			assertEquals(2, list1.size());
			assertEquals("a", list1.get(0));
			assertEquals("cd", list1.get(1));
		}
		catch (NullPointerException e) {
			
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#remove(E)}.
	 * Removes the first occurrence in this list of the specified element.
	 */
	@Test
	public void testRemoveE() {
		try {
			list1.add("a");
			list1.add("b");
			list1.add("cd");
			assertEquals(3, list1.size());
			assertEquals("a", list1.get(0));
			assertEquals("b", list1.get(1));
			assertEquals("cd", list1.get(2));
			list1.remove("b");
			assertEquals(2, list1.size());
			assertEquals("a", list1.get(0));
			assertEquals("cd", list1.get(1));
		}
		catch (NullPointerException e) {
			
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#set(int, E)}.
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 */
	@Test
	public void testSet() {
		try {
			list1.add("a");
			list1.add("b");
			list1.add("cd");
			assertEquals(3, list1.size());
			assertEquals("a", list1.get(0));
			assertEquals("b", list1.get(1));
			assertEquals("cd", list1.get(2));
			list1.set(1, "e");
			assertEquals(3, list1.size());
			assertEquals("a", list1.get(0));
			assertEquals("e", list1.get(1));
			assertEquals("cd", list1.get(2));
		}
		catch (NullPointerException e) {
			
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#isEmpty()}.
	 * Returns true if this list contains no elements.
	 */
	@Test
	public void testIsEmpty() {
		assertEquals(0, list1.size());
		
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#contains(E)}.
	 * Returns true if this list contains the specified element.
	 */
	@Test
	public void testContains() {
		try {
		list1.add("a");
		list1.add("b");
		list1.add("cd");
		
		assertEquals(3, list1.size());
		assertEquals(true, list1.contains("a"));
		assertEquals(true, list1.contains("b"));
		assertEquals(true, list1.contains("cd"));
		assertEquals(false, list1.contains("e"));
		
		}
		catch(NullPointerException e) {
			
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#toArray(E[])}.
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 */
	@Test
	public void testToArrayEArray() {
		
		try {
			String[] strings = {};
			
			list1.add("a");
			list1.add("b");
			list1.add("cd");
			Object[] myArrayListString = list1.toArray(strings);
			
			assertEquals("a", myArrayListString[0]);
			assertEquals("b", myArrayListString[1]);
			assertEquals("cd", myArrayListString[2]);
			
			
		}
		catch(NullPointerException e) {
			
			assertTrue(true);
		}
		
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#toArray()}.
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 */
	@Test
	public void testToArray() {
		list1.add("a");
		list1.add("b");
		list1.add("cd");
		Object[] toHold = list1.toArray();
		
		assertEquals(3, toHold.length);
		assertEquals("a", toHold[0]);
		assertEquals("b", toHold[1]);
		assertEquals("cd", toHold[2]);
		
		
	}

	/**
	 * Test method for {@link ListADT.MyArrayList#iterator()}.
	 * Returns an iterator over the elements in this list, in proper sequence.
	 */
	@Test
	public void testIterator() {
		list1.add("a");
		list1.add("b");
		list1.add("cd");
		Iterator<String> iterator = list1.iterator();
		
		while(iterator.hasNext()) {
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("cd", iterator.next());
			
		}
		
		
	}

}
