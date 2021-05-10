package utilities;

import java.util.EmptyStackException;

import utilities.MyArrayList.MyArrayListIterator;

/**
 * MyStack.java - This class is a ArrayList implementation of the StackADT
 * interface.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 10, 2021
 * @param <E> The type of elements this list holds.
 */
public class MyStack<E> implements StackADT<E> {

	/**
	 * ArrayList Attribute.
	 */
	private MyArrayList<E> myArrayList;

	/**
	 * Constructs an empty stack with the default capacity.
	 */
	public MyStack() {
		myArrayList = new MyArrayList<E>();
	}

	/**
	 * Constructs an empty stack with the specified capacity.
	 * 
	 * @param size - specified Array size.
	 */
	public MyStack(int size) {
		myArrayList = new MyArrayList<E>(size);
	}

	/**
	 * The size method will return the current element count contained in the list.
	 * 
	 * @return size - size of ArrayList
	 */
	@Override
	public int size() {
		return myArrayList.size();
	}

	/**
	 * Puts the element E on top of the stack. This has the same effect as: add(E to
	 * Add) method.
	 * 
	 * @param toPush
	 */
	@Override
	public void push(E toPush) {
		myArrayList.add(toPush);
	}

	/**
	 * Takes the topmost element of the stack.
	 *
	 * @return E object at the top of this stack.
	 */
	@Override
	public E pop() {

		try {
			E popedObject = myArrayList.get(size() - 1);
			myArrayList.remove(popedObject);
			return popedObject;
		} catch (EmptyStackException e) {
			return null;
		}
	}

	/**
	 * Returns the topmost element in the stack without removing it.
	 * 
	 * @return E object a t the top of this stack.
	 */
	@Override
	public E peek() {

		try {
			return myArrayList.get(size() - 1);
		} catch (EmptyStackException e) {
			return null;
		}
	}

	/**
	 * Returns the 1-based position where an object is on this stack.
	 * 
	 * @param toSearch - the desired object.
	 * @return the 1-based position from the top of the stack where the object is
	 *         located.
	 */
	@Override
	public int search(E toSearch) {

		for (int i = 0; i < size(); i++) {
			if (myArrayList.get(i).equals(toSearch)) {
				return i + 1; // stack method returns from 1
			}
		}
		return -1;
	}

	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	@Override
	public void removeAll() {

		myArrayList.clear();
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {

		return myArrayList.isEmpty();
	}

	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the java.util.Collection.toArray(Object
	 * []) method.
	 * 
	 * @param toHold The array into which the elements of this stack are to be
	 *               stored, if it is big enough; otherwise, a new array of the same
	 *               runtime type is allocated for this purpose.
	 * @return An array containing the elements of this stack.
	 * @throws NullPointerException If the specified array is null.
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {

		return (E[]) myArrayList.toArray(toHold);
	}

	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence. Obeys the general contract of the
	 * java.util.Collection.toArray()method.
	 * 
	 * @return An array containing all of the elements in this stack in proper
	 *         sequence.
	 */
	@Override
	public Object[] toArray() {

		return myArrayList.toArray();

	}

	/**
	 * Returns an iterator over the elements in this stack, in proper sequence.
	 * 
	 * @return An iterator over the elements in this stack, in proper sequence. NB:
	 *         The return is of type utilities.Iteratorr.
	 */
	@Override
	public Iterator<E> iterator() {

		return myArrayList.iterator();
	}

}