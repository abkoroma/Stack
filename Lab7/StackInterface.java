
public interface StackInterface<E> {

	/**
	 * Removes all of the elements from this stack. The Stack will be empty after this call returns.
	 */
	public void clear();
	
	/**
	 * Tests if this stack is empty.
	 * @return true if and only if this stack contains no items; false otherwise.
	 */
	public boolean empty();
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return the object at the top of this stack.
	 */
	public E peek();
	
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * @return The object at the top of this stack.
	 */
	public E pop();
	
	/**
	 * Pushes an item onto the top of this stack.
	 * @param item the item to be pushed onto this stack.
	 * @return the item argument.
	 */
	public E push(E item);
	
	/**
	 * Returns the 1-based position where an object is on this stack. If the object o occurs as an item in this stack, this method returns the distance from the top of the stack of the occurrence nearest the top of the stack; the topmost item on the stack is considered to be at distance 1. The equals method is used to compare o to the items in this stack.
	 * @param o the desired object.
	 * @return the 1-based position from the top of the stack where the object is located; the return value -1 indicates that the object is not on the stack.
	 */
	public int search(Object o);
	
	/**
	 * Returns the number of components in this stack.
	 * @return the number of components in this stack.
	 */
	public int size();
	
	
	
}
