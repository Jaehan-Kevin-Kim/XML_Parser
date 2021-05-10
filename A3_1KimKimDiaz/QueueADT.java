package utilities;

import java.io.Serializable;

/**
 * The QueueADT interface. The Queue represents a data structure 
 * designed to have elements inserted at the end of the queue, and
 * elements removed from the beginning of the queue. A Queue is a
 * linear ADT, in which the first element inserted is the first 
 * element to be retrieved. First In/First Out(FIFO).
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 20, 2021
 * @param <E> The type of elements this list holds.
 */
public interface QueueADT<E> extends Serializable {
	
	/**
	 * The size method will return the current element count contained 
	 * in the list.
	 * 
	 * @return The current element count.
	 */
	public int size();
	
	/**
	 * Puts the element E to the tail of the queue. This has the 
	 * same effect as: offer method.
	 * Pre-Condition: E is not null.
	 * Post-Condition: E is added to the top of the collection.
	 * @param toPush - Element to be inserted.
	 */
	public void enqueue(E toPush);
	
	/**
	 * Retrieves and removes the head of this queue.
	 * Pre-Condition: Queue is not empty
	 * Post-Condition: Post returns the head element of this queue.
	 * @return E object at the bottom of this queue.
	 */
	public E dequeue();

	/**
	 * Returns the topmost element in the queue without removing it.
	 * Pre-Condition: Queue is not empty
	 * Post-Condition: Returns the top most element without removing
	 * it from the stack.
	 * @return E object a t the top of this stack.
	 */
	public E peek();
	
	/**
	 * Tests if the queue is empty.
	 * Pre-Condition: -
	 * Post-Condition: Returns true if queue is empty.
	 * @return true if and only if this queue contains no items;
	 * 		false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Tests if the queue is of static capacity.
	 * Pre-Condition: -
	 * Post-Condition: Returns true if queue is full.
	 * @return true only if this queue is full;
	 * 		false This queue is not full.
	 */
	public boolean isFull();
	
	/**
	 * Removes all items from this queue.
	 * Pre-Condition: Stack is not empty.
	 * Post-Condition: Removes all the elements from collection.
	 */
	public void dequeueAll();
	
	/**
	 * Compares the specified queue with this queue for equality.
	 * Precondition: Queue is not null.
	 * Postcondition: True: same order and same items. False different order or differnt item(s).
	 * 
	 * @param that - queue to be compared for equality with this queue.
	 * @return true if the specified object is equal to this collection.
	 */
	public boolean equals(QueueADT<E> that);
	
	/**
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the java.util.Collection.toArray(Object []) method.
	 * 
	 * @param toHold
	 *			The array into which the elements of this queue are to be
	 * 			stored, if it is big enough; otherwise, a new array of the
	 * 			same runtime type is allocated for this purpose.
	 * @return An array containing the elements of this queue.
	 * @throws NullPointerException
	 * 			If the specified array is null.
	 */
	public E[] toArray( E[] toHold ) throws NullPointerException;
	
	/**
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence. Obeys the general contract of the java.util.Collection.toArray()method.
	 * 
	 * @return An array containing all of the elements in this queue in proper
	 * 			sequence.
	 */
	public Object[] toArray();
	
	/**
	 * Returns an iterator over the elements in this queue, in proper sequence.
	 * 
	 * @return An iterator over the elements in this queue, in proper sequence.
	 * 			NB: The return is of type linearUtilities.Iterator, not 
	 * 			java.util.Iterator.
	 */
	public Iterator<E> iterator();
}