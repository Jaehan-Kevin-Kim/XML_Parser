package utilities;

import java.io.Serializable;

/**
 * The ListADT interface is designed to be used as a basis for all the Linear
 * data structures that will be developed in the CPRG 311 class at SAIT. The
 * implementors of this interface will be required to add all the functionality.
 * 
 * @param <E> The type of elements this list holds.
 */
public interface ListADT<E> extends Serializable {
	/**
	 * The size method will return the current element count contained in the list.
	 * Post Condition:
	 * 
	 * @return The current element count.
	 */
	public int size();

	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	public void clear();

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 * 
	 * @param index - The index at which the specified element is to be inserted.
	 *              The element is inserted before the existing element at [index],
	 *              or at the end if index is equal to the size (size()).
	 * @param toAdd - The element to be inserted.
	 * @return true if the element is added successfully.
	 * @throws NullPointerException      If the specified element is null and the
	 *                                   list implementation does not support having
	 *                                   null elements.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (index <
	 *                                   0 || index > size()).
	 */
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException;

	/**
	 * Appends the specified element to the end of this list. Implementations that
	 * support this operation may place limitations on what elements may be added to
	 * this list. In particular, some implementations will refuse to add null
	 * elements. List classes should clearly specify in their documentation any
	 * restrictions on what elements may be added.
	 * 
	 * @param toAdd Element to be appended to this list.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException If the specified element is null and the list
	 *                              implementation does not support having null
	 *                              elements.
	 */
	public boolean add(E toAdd) throws NullPointerException;

	/**
	 * Appends all of the elements in the specified java.utilCollection to the end
	 * of this list, in the order that they are returned by the specified
	 * collection's Iterator. The behaviour of this operation is unspecified if the
	 * specified collection is modified while the operation is in progress. (Note
	 * that this will occur if the specified collection is this list, and it's
	 * nonempty.)
	 * 
	 * @param toAdd The new sub list to be added.
	 * @return true If the operation is successful.
	 * @throws NullPointerException If the specified element is null and the list
	 *                              implementation does not support having null
	 *                              elements.
	 */
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException;

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index Index of element to return.
	 * @return The element at the specified position in this list.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (index <
	 *                                   0 || index >= size()).
	 */
	public E get(int index) throws IndexOutOfBoundsException;

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 * 
	 * @param index The index of the element to remove.
	 * @return The removed element.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (index <
	 *                                   0 || index >= size()).
	 */
	public E remove(int index) throws IndexOutOfBoundsException;

	/**
	 * Removes the first occurrence in this list of the specified element. If this
	 * list does not contain the element, it is unchanged. More formally, removes
	 * the element with the lowest index i such that o.equals(get(i)) (if such an
	 * element exists).
	 * 
	 * @param toRemove The element to be removed from this list.
	 * @return The element which is being removed, or null if the list does not
	 *         contain the element.
	 * @throws NullPointerException If the specified element is null and the list
	 *                              implementation does not support having null
	 *                              elements.
	 */
	public E remove(E toRemove) throws NullPointerException;

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index    The index of the element to replace.
	 * @param toChange Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException      If the specified element is null and the
	 *                                   list implementation does not support having
	 *                                   null elements.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (index <
	 *                                   0 || index >= size()).
	 */
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException;

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if this list contains no elements.
	 */
	public boolean isEmpty();

	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e such
	 * that toFind.equals(e).
	 * 
	 * @param toFind The element whose presence in this list is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws NullPointerException If the specified element is null and the list
	 *                              implementation does not support having null
	 *                              elements.
	 */
	public boolean contains(E toFind) throws NullPointerException;

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the java.util.Collection.toArray(Object
	 * []) method.
	 * 
	 * @param toHold The array into which the elements of this list are to be
	 *               stored, if it is big enough; otherwise, a new array of the same
	 *               runtime type is allocated for this purpose.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException If the specified array is null.
	 */
	public E[] toArray(E[] toHold) throws NullPointerException;

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the
	 * java.util.Collection.toArray()method.
	 * 
	 * @return An array containing all of the elements in this list in proper
	 *         sequence.
	 */
	public Object[] toArray();

	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence. NB:
	 *         The return is of type utilities.Iterator.
	 */
	public Iterator<E> iterator();
}
