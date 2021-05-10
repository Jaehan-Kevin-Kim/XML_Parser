package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.Iterator;
import utilities.MyDLL;
/**
 * Doubly Linked List Test class
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 21, 2021
 */
public class MyDLLTests {
	
	MyDLL<String> dll1;
	MyDLL<String> dll2;
	
	/**
	 * @Before - Will execute the method before each test. 
	 * 		This method can prepare the test environment (e.g. read input data, initialize the class). 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dll1 = new MyDLL<>();
		dll2 = new MyDLL<>();
	}
	
	/**
	 * @BeforeClass - Will execute the method once, before the start of all tests. 
	 * 		This can be used to perform time intensive activities, for example to connect to a database. 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @AfterClass - Will execute the method once, after all tests have finished. 
	 * 		This can be used to perform clean-up activities, for example to disconnect from a database. 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	/**
	 * @After - Will execute the method after each test. 
	 * 		This method can cleanup the test environment (e.g. delete temporary data, restore defaults). 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		dll1=null;
		dll2=null;
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#clear()}.
	 * Removes all of the elements from this DLL.
	 */
	@Test 
	public void testClearDLL() {
		dll1.clear();
		assertTrue(dll1.isEmpty());
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#add(int,E)}. 
	 * Adding an element at the specified position.
	 */
	@Test
	public void testAdd() {

		try {
			dll2.add(0, "A");
			dll2.add(1, "B");
			dll2.add(2, "C");
			dll2.add(3, "D");
			dll2.add(4, "E");

			assertFalse(dll2.isEmpty());
			assertEquals(5, dll2.size());
			assertEquals("A", dll2.get(0));
			assertEquals("B", dll2.get(1));
			assertEquals("C", dll2.get(2));
			assertEquals("D", dll2.get(3));
			assertEquals("E", dll2.get(4));

		} catch(IndexOutOfBoundsException e)
		{
			
			assertTrue(true);
		}
		
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#add(int,E)}. 
	 * Adding an element at the specified position.
	 * @throws NullPointerException - If the specified element is null
	 */
	@Test
	public void testAddNullPointer() throws NullPointerException {
		try{
			dll1.add(0, "A");
			dll1.add(1, "B");
			dll1.add(2, null);
			
			assertFalse(dll1.isEmpty());
			
			fail("NullPointerException thrown");
		} catch (NullPointerException e){
			assertTrue(true);
		}

	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#add(int,E)}. 
	 * Adding an element at the specified position.
	 * @throws IndexOutOfBoundsException - If the index is out of range
	 */
	@Test
	public void testAddIndexOutOfBounds() throws IndexOutOfBoundsException {
		try{

			dll1.add(4, "D");
						
			fail("IndexOutOfBoundsException thrown");
		} catch (IndexOutOfBoundsException e){
			
			assertTrue(true);
		}
	}
		
	/**
	 * Test method for {@link ListADT.MyDLL#add(E)}. 
	 * Adding an element at the end of the list.
	 */
	@Test
	public void testAppend() {
		try {
			dll2.add("A");
			dll2.add("B");
			dll2.add("C");
			dll2.add("D");
			
			assertFalse(dll2.isEmpty());
			
			assertEquals(4, dll2.size());
			
			assertEquals("A", dll2.get(0));
			assertEquals("B", dll2.get(1));
			assertEquals("C", dll2.get(2));
			assertEquals("D", dll2.get(3));
		} catch (IndexOutOfBoundsException e){

			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#add(E)}. 
	 * Adding an element at the end of the list.
	 * @throws NullPointerException - If the specified element is null
	 */
	@Test
	public void testAppendNullPointer() throws NullPointerException {
		try{
			dll2.add("A");
			dll2.add("B");
			dll2.add(null);
						
			fail("NullPointerException thrown");
		} catch (NullPointerException e){
			
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#addAll(ListADT<?extendsE>)}. 
	 * Appends all of the elements of the specified collection to the 
	 * end of this DLL.
	 */
	@Test
	public void testAddAll() {
		try {
			dll1.add("A");
			dll1.add("B");
			dll2.add("C");
			dll2.add("D");
			dll1.addAll(dll2);
			assertFalse(dll1.isEmpty());
			assertEquals(4, dll1.size());
			assertTrue(dll1.contains("A"));
			assertTrue(dll1.contains("B"));
			assertTrue(dll1.contains("C"));
			assertTrue(dll1.contains("D"));
			
		} catch (NullPointerException e) {
			
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#addAll(ListADT<?extendsE>)}. 
	 * Appends all of the elements of the specified collection to the 
	 * end of this DLL.
	 * @throws NullPointerException - If the specified element is null
	 */
	@Test
	public void testAddAllNullPointer() throws NullPointerException {
		try{ 
			dll1.add("A");
			dll1.add("B");
			dll2 = null;
			dll1.addAll(dll2);
			
			fail("NullPointerException thrown");

		} catch (NullPointerException e) {
			
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link ListADT.MyDLL#get(int)}.
	 * Returns the element at the specified position in this DLL.
	 */
	@Test
	public void testGetDLL() {
		try {
			dll1.add("A");
			dll1.add("B");
			assertFalse(dll1.isEmpty());
			assertEquals("A", dll1.get(0));
			assertEquals("B", dll1.get(1));
		} catch (IndexOutOfBoundsException e){

			assertTrue(true);
		}
	}
		
	/**
	 * Test method for {@link ListADT.MyDLL#remove(int)}.
	 * Removes the element at the specified position in this DLL.
	 */
	@Test
	public void testRemoveIndex()  {
		try {
			dll1.add("A");
			dll1.add("B");
			dll1.add("C");
			
			assertFalse(dll1.isEmpty());
			assertEquals("A", dll1.get(0));
			assertEquals("B", dll1.get(1));
			assertEquals("C", dll1.get(2));
			
			dll1.remove(1);

			assertEquals(false, dll1.contains("B"));
		} catch (IndexOutOfBoundsException e){

			assertTrue(true);
		}	
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#remove(int)}.
	 * Removes the element at the specified position in this DLL.
	 * @throws IndexOutOfBoundsException - If the index is out of range
	 */
	@Test
	public void testRemoveIndexOutOfBounds() throws IndexOutOfBoundsException {
		try {
			dll1.add("A");
			dll1.add("B");
			dll1.add("C");
			
			assertFalse(dll1.isEmpty());
			assertEquals("A", dll1.get(0));
			assertEquals("B", dll1.get(1));
			assertEquals("C", dll1.get(2));
			
			dll1.remove(-1);
			
//			fail("IndexOutOfBoundsException thrown");
		} catch (IndexOutOfBoundsException e){
			
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#remove(E)}.
	 * Removes the first occurrence in this DLL of the specified element.
	 */
	@Test
	public void testRemoveE() {
		try {
			dll1.add("A");
			dll1.add("B");
			dll1.add("C");
			assertFalse(dll1.isEmpty());
			assertEquals("A", dll1.get(0));
			assertEquals("B", dll1.get(1));
			assertEquals("C", dll1.get(2));
			
			dll1.remove("B");
			assertEquals(false, dll1.contains("B"));
		} catch (IndexOutOfBoundsException e){
			
			assertTrue(true);
		}
		
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#remove(E)}.
	 * Removes the first occurrence in this DLL of the specified element.
	 * @throws NullPointerException - If the specified element is null
	 */
	@Test
	public void testRemoveENullPointer() throws NullPointerException {
		
		try {
			dll2.add("A");
			dll2.remove(null);
			
			fail("NullPointerException thrown.");
		} catch (NullPointerException e){
			
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListAdt.MyDLL#set(int, E)}.
	 * Replaces the element at the specified position in this DLL with the
	 * specified element.
	 * @throws NullPointerException - If the specified element is null
	 * @throws IndexOutOfBoundsException - If the index is out of range
	 */
	@Test
	public void testSet() throws NullPointerException, IndexOutOfBoundsException {
		try {
			dll2.add("A");
			dll2.add("B");
			dll2.add("D");
			dll2.add("E");
			
			assertEquals(false, dll2.isEmpty());
			assertEquals("A", dll2.get(0));
			assertEquals("B", dll2.get(1));
			assertEquals("D", dll2.get(2));
			assertEquals("E", dll2.get(3));
			
			dll2.set(2, "C");
			
			assertEquals("C", dll2.get(2));
			
		} catch (NullPointerException e){
			
			assertTrue(true);
		} catch (IndexOutOfBoundsException e){
			
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListAdt.MyDLL#set(int, E)}.
	 * Replaces the element at the specified position in this DLL with the
	 * specified element.
	 * @throws NullPointerException - If the specified element is null
	 */
	@Test
	public void testSetNullPointer() throws NullPointerException {
		try{
			dll2.add("A");
			dll2.add("B");
			dll2.add("D");
			
			assertEquals(false, dll2.isEmpty());
			assertEquals("A", dll2.get(0));
			assertEquals("B", dll2.get(1));
			assertEquals("D", dll2.get(2));
			
			dll2.set(1, null);
			
			fail("NullPointerException thrown");
		} catch (NullPointerException e){
			
			assertTrue(true);
		} catch (IndexOutOfBoundsException e){
			
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListAdt.MyDLL#set(int, E)}.
	 * Replaces the element at the specified position in this DLL with the
	 * specified element.
	 * @throws IndexOutOfBoundsException - If the index is out of range
	 */
	@Test
	public void testSetIndexOutOfBounds() throws IndexOutOfBoundsException {
		try{
			dll2.add("A");
			dll2.add("B");
			dll2.add("D");
			
			assertEquals(false, dll2.isEmpty());
			assertEquals("A", dll2.get(0));
			assertEquals("B", dll2.get(1));
			assertEquals("D", dll2.get(2));
			
			dll2.set(4, "F");
			
			fail("IndexOutOfBoundsException thrown");
		} catch (NullPointerException e){
			
			assertTrue(true);
		} catch (IndexOutOfBoundsException e){
			
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#isEmpty()}.
	 * Returns true if this DLL contains no elements.
	 */
	@Test
	public void testIsEmpty() {
		dll1.clear();
		assertTrue(dll1.isEmpty());
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#contains(E)}.
	 * Returns true if this DLL contains the specified element.
	 */
	@Test
	public void testContains(){
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");
		
		assertFalse(dll1.isEmpty());
		
		assertEquals(true, dll1.contains("A"));
		assertEquals(true, dll1.contains("B"));
		assertEquals(true, dll1.contains("C"));
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#contains(E)}.
	 * Returns true if this DLL contains the specified element.
	 * @throws NullPointerException - If the specified element is null
	 */
	@Test
	public void testContainsNullPointer() throws NullPointerException {
		try {
			dll1.add("A");

			assertFalse(dll1.isEmpty());

			dll1.contains(null);
			
			fail("NullPointerException thrown");
			
		} catch(NullPointerException e) {
			
			assertTrue(true);
		}
				
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#toArray(E)}.
	 * Returns an array containing all of the elements in this DLL in proper
	 * sequence.
	 */
	@Test
	public void testEToArray(){
		
		try {
			String [] strings = {};
			
			dll2.add("A");
			dll2.add("B");
			dll2.add("C");
			
			Object[] myDLLString = dll2.toArray(strings);
			
			assertEquals("A", myDLLString[0]);
			assertEquals("B", myDLLString[1]);
			assertEquals("C", myDLLString[2]);

			
		} catch(NullPointerException e) {
			
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#toArray(E)}.
	 * Returns an array containing all of the elements in this DLL in proper
	 * sequence.
	 * @throws NullPointerException - If the specified element is null
	 */
	@Test
	public void testEToArrayNullPointer() throws NullPointerException {
		
		try {
			String [] strings= null;
			
			dll2.add("a");
			
			Object[] myDLLString = dll2.toArray(strings);
			
			fail("NullPointerException thrown");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#toArray()}.
	 * Returns an array containing all of the elements in this DLL in proper
	 * sequence.
	 */
	@Test
	public void testToArray() {
		dll1.add("A");
		dll1.add("B");
		dll1.add("C");
		
		Object [] myDLLArray = dll1.toArray();
		assertEquals("A", myDLLArray[0]);
		assertEquals("B", myDLLArray[1]);
		assertEquals("C", myDLLArray[2]);
	}
	
	/**
	 * Test method for {@link ListADT.MyDLL#iterator()}.
	 * Returns an iterator over the elements in this DLL, in proper sequence.
	 */
	@Test
	public void testDLLIterator() {
		dll2.add("A");
		dll2.add("B");
		dll2.add("C");
		
		Iterator<String> DLLIterator = dll2.iterator();
		
		while(DLLIterator.hasNext()) {
			assertEquals("A", DLLIterator.next());
			assertEquals("B", DLLIterator.next());
			assertEquals("C", DLLIterator.next());
				
			}
	}
}
