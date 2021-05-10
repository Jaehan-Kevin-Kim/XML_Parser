package utilities;

import java.io.Serializable;

/**
 * The StackADT interface. The Stack data structure is based on the
 * Last In First Out principle. A Stack is a linear ADT, which can be 
 * accessed only at one of its ends for storing and retrieving data.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 20, 2021
 * @param <E> The type of elements this list holds.
 */
public interface StackADT<E> extends Serializable {
	
	/**
	 * The size method will return the current element count contained 
	 * in the list.
	 * 
	 * @return The current element count.
	 */
	public int size();
	
	/**
	 * Puts the element E on top of the stack. This has the 
	 * same effect as: add(E to Add) method.
	 * Pre-Condition: E is not null.
	 * Post-Condition: E is added to the top of the collection.
	 * @param toPush - Element to be inserted in the stack.
	 */
	public void push(E toPush);
	
	/**
	 * Takes the topmost element of the stack.
	 * Pre-Condition: Stack is not empty
	 * Post-Condition: Post returns the top most element.
	 * @return E object at the top of this stack.
	 */
	public E pop();

	/**
	 * Returns the topmost element in the stack without removing it.
	 * Pre-Condition: Stack is not empty
	 * Post-Condition: Returns the top most element without removing
	 * it from the stack.
	 * @return E object a t the top of this stack.
	 */
	public E peek();
	
	/**
	 * Returns the 1-based position where an object is on this stack.
	 * Pre-Condition: Stack is not empty.
	 * Post-Condition: Returns the position of element.
	 * @param toSearch - the desired object.
	 * @return the 1-based position from the top of the stack where 
	 * 		the object is located.
	 */
	public int search(E toSearch);
	
	/**
	 * Removes from this stack all of its elements that are contained.
	 * Pre-Condition: Stack is not empty.
	 * Post-Condition: Removes all the elements from collection.
	 */
	public void removeAll();
	
	/**
	 * Tests if the stack is empty.
	 * Pre-Condition: -
	 * Post-Condition: Returns true if stack is empty.
	 * @return true if and only if this stack contains no items;
	 * 		false otherwise.
	 */
	public boolean isEmpty();	
	
	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the java.util.Collection.toArray(Object []) method.
	 * Pre-Condition: Stack is not empty.
	 * Post-Condition: Returns an array containing elements of the stack.
	 * 
	 * @param toHold
	 *			The array into which the elements of this stack are to be
	 * 			stored, if it is big enough; otherwise, a new array of the
	 * 			same runtime type is allocated for this purpose.
	 * @return An array containing the elements of this stack.
	 * @throws NullPointerException
	 * 			If the specified array is null.
	 */
	public E[] toArray( E[] toHold ) throws NullPointerException;
	
	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence. Obeys the general contract of the java.util.Collection.toArray()method.
	 * Pre-Condition: Stack is not empty.
	 * Post-Condition: Returns an array containing elements of the stack.
	 * 
	 * @return An array containing all of the elements in this stack in proper
	 * 			sequence.
	 */
	public Object[] toArray();
	
	/**
	 * Returns an iterator over the elements in this stack, in proper sequence.
	 * 
	 * @return An iterator over the elements in this stack, in proper sequence.
	 * 			NB: The return is of type linearUtilities.Iterator, not 
	 * 			java.util.Iterator.
	 */
	public Iterator<E> iterator();
}
