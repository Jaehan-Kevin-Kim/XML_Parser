package utilities;

/**
 * MyDLLNode.java - implements a Doubly Linked List node. This node consists of
 * an element and two links: to its successor and predecessor.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version March 10, 2021
 */
public class MyDLLNode {

	private Object element;

	private MyDLLNode successor, predecessor;

	/**
	 * Create a new Node with three parameters
	 * 
	 * @param o object data new node
	 * @param n successor node
	 * @param p predecessor node
	 */

	public MyDLLNode(Object o, MyDLLNode n, MyDLLNode p) {
		this.element = o;
		this.successor = n;
		this.predecessor = p;
	}

	/**
	 * Create a new Node
	 * 
	 * @param o object data for new node
	 */
	public MyDLLNode(Object o) {
		this.element = 0;
		this.successor = this.predecessor = null;
	}

	/**
	 * Sets the next node
	 * 
	 * @param n next node to set
	 */
	public void setNext(MyDLLNode n) {
		this.successor = n;
	}

	/**
	 * Sets the previous node
	 * 
	 * @param p previous node to set
	 */
	public void setPrevious(MyDLLNode p) {
		this.predecessor = p;
	}

	/**
	 * Gets the next node.
	 * 
	 * @return next node
	 */
	public MyDLLNode getNext() {
		return successor;
	}

	/**
	 * Gets the previous node.
	 * 
	 * @return previous node
	 */
	public MyDLLNode getPrevious() {
		return predecessor;
	}

	/**
	 * Sets the data for the node
	 * 
	 * @param o new data to set
	 */
	public void setData(Object o) {
		this.element = o;
	}

	/**
	 * Gets the data from the node
	 * 
	 * @return gets data from the node
	 */
	public Object getData() {
		return element;
	}
}
