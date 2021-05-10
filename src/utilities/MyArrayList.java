package utilities;

import java.util.NoSuchElementException;

/**
 * The MyArrayList class. This class is the implementation of the ListADT
 * interface.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 10, 2021
 * @param <E> The type of elements this list holds.
 */
public class MyArrayList<E> implements ListADT<E> {

	/**
	 * ArrayList for Object E[].
	 */
	private E[] myArray;

	/**
	 * Size of ArrayList.
	 */
	private int size;

	/**
	 * Constructs an ArrayList with the default capacity;
	 */
	public MyArrayList() {
		this(100);
	}

	/**
	 * Constructs a list with the specified capacity.
	 * 
	 * @param size - specified Array size.
	 */
	public MyArrayList(int size) {
		myArray = (E[]) new Object[size];
	}

	/**
	 * The size method will return the current element count contained in the list.
	 * 
	 * @return size - size of ArrayList
	 */
	@Override
	public int size() {

		return size;
	}

	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	@Override
	public void clear() {
		size = 0;
		// myArray = null;

	}

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index - The index at which the specified element is to be inserted.
	 * @param toAdd - The element to be inserted.
	 * @return true if the element is added successfully.
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
			throw new NullPointerException("Element to add is null");
		}

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		try {
			for (int i = size; i >= index; i--) {
				myArray[i + 1] = myArray[i];

			}
			myArray[index] = toAdd;
			size++;

			return true;
		} catch (NullPointerException e) {
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}

	}

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param toAdd - Element to be appended to this list.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		try {

			myArray[size] = toAdd;
			size++;
			return true;

		} catch (NullPointerException e) {
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	/**
	 * Appends all of the elements of the specified collection to the end of this
	 * DLL.
	 * 
	 * @param toAdd - The new sub list to be added.
	 * @return true - If the operation is successful.
	 * @throws NullPointerException
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		try {
			int newSize = toAdd.size() + size;
			Object[] objs = new Object[newSize];

			for (int i = 0; i < newSize; i++) {
				if (i < size) {
					objs[i] = myArray[i];
				} else {
					objs[i] = toAdd.get(i - size);
				}
			}
			size = newSize;
			myArray = (E[]) objs;
			return true;
		} catch (NullPointerException e) {
			return false;

		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index - Index of element to return.
	 * @return The element at the specified position in this list.
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		try {
			return myArray[index];
		} catch (IndexOutOfBoundsException e) {
			return null;
		}

	}

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index - The index of the element to remove.
	 * @return The removed element.
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		try {
			E obj = myArray[index];

			for (int i = index + 1; i < size; i++) {
				myArray[i - 1] = myArray[i];

			}
			myArray[size] = null;
			size--;

			return obj;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * Removes the first occurrence in this list of the specified element.
	 * 
	 * @param toRemove - The element to be removed from this list.
	 * @return The element which is being removed, or null if the list does not
	 *         contain the element.
	 * @throws NullPointerException
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		try {
			int index = 0;

			while (myArray[index] != toRemove) {
				index++;
			}
			return (E) remove(index);

		} catch (NullPointerException e) {
			return null;

		}
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index    - The index of the element to replace.
	 * @param toChange - Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		E obj = myArray[index];
		myArray[index] = toChange;
		return obj;

	}

	/**
	 * Returns true if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param toFind - The element whose presence in this list is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws NullPointerException
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		try {

			for (int i = 0; i < myArray.length; i++) {
				if (myArray[i] == toFind || myArray[i].equals(toFind))
					return true;
			}
			return false;

		} catch (NullPointerException e) {
			return false;
		}

	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 * 
	 * @param toHold - The array into which the elements of this list are to be
	 *               stored.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		} else if (toHold.length < size) {
			toHold = (E[]) new Object[size];

			for (int index = 0; index < size; index++) {
				toHold[index] = myArray[index];
			}
		}

		return toHold;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 */
	@Override
	public Object[] toArray() {
		Object[] toHold = new Object[size];

		for (int index = 0; index < size; index++) {
			toHold[index] = myArray[index];
		}

		return toHold;
	}

	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {

		return new MyArrayListIterator();
	}

	/**
	 * Implementation of the Iterator interface for Doubly-Linked List.
	 * 
	 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
	 */
	public class MyArrayListIterator implements Iterator<E> {

		// attribute
		private int position;

		@Override
		public boolean hasNext() {

			return position < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (position >= size) {
				throw new NoSuchElementException();
			}
			return myArray[position++];
		}

	}
}
