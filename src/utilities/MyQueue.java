package utilities;

import java.util.ArrayList;

/**
 * MyQueue.java - This class is a Doubly-Linked List implementation
 * of the QueueADT interface.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 10, 2021
 * @param <E> The type of elements this list holds.
 */
public class MyQueue<E> implements QueueADT<E> {

	//attributes
	/**
	 * Doubly linked list for this Queue.
	 */
	private MyDLL<E> myDLL;
	
	/**
	 * Constructs a Queue with the default capacity.
	 */
	public MyQueue() {
		myDLL = new MyDLL<E>();
	}
	
	/**
	 * The size method will return the current element count contained 
	 * in the list.
	 * 
	 * @return The current element count.
	 */
	@Override
	public int size() {

		return myDLL.size();
	}

	/**
	 * Puts the element E to the tail of the queue. This has the 
	 * same effect as: offer method.
	 * 
	 * @param toPush
	 */
	@Override
	public void enqueue(E o) {

		myDLL.add(o);
	}

	/**
	 * Takes the top element of the queue.
	 * 
	 * @return E object at the bottom of this queue.
	 */
	@Override
	public E dequeue() {
		E polledObject = myDLL.get(0);
		myDLL.remove(0);
		return polledObject;
	}

	/**
	 * Returns the topmost element in the stack without removing it.
	 * 
	 * @return E object a t the top of this stack.
	 */
	@Override
	public E peek() {
		return myDLL.get(0);
	}

	/**
	 * Tests if the queue is empty.
	 * 
	 * @return true if and only if this queue contains no items;
	 * 		false otherwise.
	 */
	@Override
	public boolean isEmpty() {

		return myDLL.isEmpty();
	}

	/**
	 * Tests if the queue is of static capacity.
	 * 
	 * @return true only if this queue is full;
	 * 		false This queue is not full.
	 */
	@Override
	public boolean isFull() {
		if(myDLL.isEmpty())
		return false;
		else return true;
	}

	/**
	 * Removes all items from this queue.
	 */
	@Override
	public void dequeueAll() {
		myDLL.clear();
		
	}

	/**
	 * Verify if two queues the same order and same items.
	 * 
	 * @param Another queue.
	 * @return boolean.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(QueueADT<E> that) {
		for (int i =0; i < myDLL.size(); i++) {
			Object[] obj = that.toArray();

			if (!myDLL.get(i).equals(obj[i]) || myDLL.size()!=obj.length) {
				return false;
			}	
		}
			
		return true;
	}

	/**
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence.
	 * 
	 * @param toHold - The array into which the elements of this queue are to be
	 * 			stored.
	 * @throws NullPointerException
	 * 			If the specified array is null.
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		
		return (E[])myDLL.toArray(toHold);
	}

	/**
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence. Obeys the general contract of the java.util.Collection.toArray()method.
	 * 
	 * @return An array containing all of the elements in this queue in proper
	 * 			sequence.
	 */
	@Override
	public Object[] toArray() {

		return myDLL.toArray();
	}

	/**
	 * Returns an iterator over the elements in this queue, in proper sequence.
	 * 
	 * @return An iterator over the elements in this queue, in proper sequence.
	 * 			NB: The return is of type linearUtilities.Iterator, not 
	 * 			java.util.Iterator.
	 */
	@Override
	public Iterator<E> iterator() {

		return myDLL.iterator();
	}

}