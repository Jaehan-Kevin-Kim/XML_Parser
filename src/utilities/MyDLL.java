package utilities;

import java.util.NoSuchElementException;

/**
 * MyDLL.java - This class is a Doubly-LinkedList implementation of the ListADT.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 21, 2021
 */
public class MyDLL<E> implements ListADT<E> {

	/**
	 * Head and tail nodes of the DLL.
	 */
	private MyDLLNode head, tail;

	/**
	 * Size of the DLL.
	 */
	private int size;

	/**
	 * Constructs an empty DLL.
	 */
	public MyDLL() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * The size method will return the current element count contained in the DLL.
	 * 
	 * @return size - size of DLL.
	 */
	@Override
	public int size() {

		return size;
	}

	/**
	 * Removes all of the elements from this DLL. This list will be empty after this
	 * call returns.
	 */
	@Override
	public void clear() {
		head = tail = null;
		size = 0;

	}

	/**
	 * Inserts the specified element at the specified position in this DLL.
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
			MyDLLNode newNode = new MyDLLNode(toAdd, null, null);

			if (index == 0) {

				head = tail = newNode;
				head.setPrevious(null);
				tail.setNext(null);

				size++;

			} else if (index == size) {

				add(toAdd);

			} else {

				MyDLLNode tmp = head;
				MyDLLNode next = tmp.getNext();

				for (int i = 0; i < index - 1; i++) {
					tmp = tmp.getNext();
					next = tmp.getNext();
				}

				next.setNext(newNode);
				newNode.setPrevious(next);
				newNode.setNext(tmp);
				tmp.setPrevious(newNode);

				size++;
			}

			return true;

		} catch (NullPointerException e) {

			return false;

		} catch (IndexOutOfBoundsException e) {

			return false;
		}
	}

	/**
	 * Appends the specified element to the end of this DLL.
	 * 
	 * @param toAdd - Element to be appended to this DLL.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {

		if (toAdd == null) {
			throw new NullPointerException();
		}

		try {
			MyDLLNode newNode = new MyDLLNode(toAdd, null, null);

			if (!isEmpty()) {
				tail.setNext(newNode);
				newNode.setPrevious(tail);
				tail = newNode;
				tail.setNext(null);
			} else {
				head = tail = newNode;
				head.setPrevious(null);
				tail.setNext(null);

			}

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
		if (toAdd == null) {
			throw new NullPointerException();
		}

		try {
			MyDLLIterator i = (MyDLL<E>.MyDLLIterator) toAdd.iterator();

			while (i.hasNext()) {
				this.add(i.next());
			}

			return true;
		} catch (NullPointerException e) {

			return false;

		}
	}

	/**
	 * Returns the element at the specified position in this DLL.
	 * 
	 * @param index - Index of element to return.
	 * @return The element at the specified position in this DLL.
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		try {
			if (index > size / 2) {
				index = (size - 1) - index;
				MyDLLNode tmp = tail;
				while (index > 0) {
					tmp = tmp.getPrevious();

					index--;
				}
				return (E) tmp.getData();
			} else {
				MyDLLNode tmp = head;
				while (index > 0) {
					tmp = tmp.getNext();
					index--;
				}
				return (E) tmp.getData();
			}

		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * Removes the element at the specified position in this DLL.
	 * 
	 * @param index - The index of the element to remove.
	 * @return The removed element.
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		try {
			MyDLLNode tmp = head;

			if (index == 0) {
				head = tmp.getNext();
				tmp.setNext(null);

				size--;
				return (E) tmp.getData();

			} else {

				MyDLLNode toRemove = tmp.getNext();

				for (int i = 0; i < index - 1; i++) {
					tmp = tmp.getNext();
					toRemove = tmp.getNext();
				}

				tmp.setNext(toRemove.getNext());

				toRemove.setNext(null);

				size--;
				return (E) toRemove.getData();
			}

		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * Removes the first occurrence in this DLL of the specified element.
	 * 
	 * @param toRemove - The element to be removed from this DLL.
	 * @return The element which is being removed, or null if the list does not
	 *         contain the element.
	 * @throws NullPointerException
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}

		try {

			MyDLLNode tmp = head;

			int index = 0;

			while (tmp != null && tmp.getData() != toRemove) {

				tmp = tmp.getNext();
				index++;
			}

			return (E) remove(index);

		} catch (NullPointerException e) {

			return null;

		}
	}

	/**
	 * Replaces the element at the specified position in this DLL with the specified
	 * element.
	 * 
	 * @param index    - The index of the element to replace.
	 * @param toChange - Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
			throw new NullPointerException("Element to add is null");
		}

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		try {

			MyDLLNode setNode = new MyDLLNode(toChange, null, null);
			MyDLLNode tmp = head;
			MyDLLNode tmpNxt = tmp.getNext();

			for (int i = 0; i < index - 1; i++) {
				tmp = tmp.getNext();
				tmpNxt = tmp.getNext();
			}

			tmp.setNext(setNode);

			setNode.setNext(tmpNxt.getNext());
			tmpNxt.setNext(null);
//			Object tmp = get(index);
//			
//			add(index, toChange);
//			
//			remove(index+1);

			return (E) tmpNxt.getData();
		} catch (NullPointerException e) {

			return null;

		} catch (IndexOutOfBoundsException e) {

			return null;
		}
	}

	/**
	 * Returns true if this DLL contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Returns true if this DLL contains the specified element.
	 * 
	 * @param toFind - The element whose presence in this DLL is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws NullPointerException
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}

		MyDLLNode tmp = head;
		while (tmp != null) {
			if (tmp.getData() == toFind) {
				return true;
			}
			tmp = tmp.getNext();
		}

		return false;
	}

	/**
	 * Returns an array containing all of the elements in this DLL in proper
	 * sequence.
	 * 
	 * @param toHold - The array into which the elements of this DLL are to be
	 *               stored.
	 * @return An array containing the elements of this DLL.
	 * @throws NullPointerException
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		} else if (toHold.length < size) {
			toHold = (E[]) new Object[size];

			int index = 0;

			for (MyDLLNode node = head; node != null; node = node.getNext()) {
				toHold[index++] = (E) node.getData();
			}
		}

		return toHold;
	}

	/**
	 * Returns an array containing all of the elements in this DLL in proper
	 * sequence.
	 */
	@Override
	public Object[] toArray() {

		Object[] dllArray = new Object[size];
		int index = 0;

		for (MyDLLNode node = head; node != null; node = node.getNext()) {
			dllArray[index++] = node.getData();
		}
		return dllArray;
	}

	/**
	 * Returns an iterator over the elements in this DLL, in proper sequence.
	 * 
	 * @return An iterator over the elements in this DLL, in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyDLLIterator();
	}

	/**
	 * Implementation of the Iterator interface for Doubly-Linked List.
	 * 
	 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
	 */
	private class MyDLLIterator implements Iterator<E> {
		private MyDLLNode current = head;
		private int position;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext())
				throw new NoSuchElementException();

			Object tmp = current.getData();
			current = current.getNext();
			return (E) tmp;

		}

	}

}
