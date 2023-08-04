package jsjf;

import jsjf.exceptions.*;
import java.util.Iterator;

/**
 * Represents a linked implementation of a stack.
 *Yixin Wang 
 *T00735859
*/
public class LinkedStack<T> implements StackADT<T>
{
	private int count,capacity;  
	private LinearNode<T> top; 

	/**
	 * Creates an empty stack.
	 */
	public LinkedStack()
	{
		count = 0;
		top = null;
		capacity = 5; //the max size of the stack
		
	}

	/**
	 * Adds the specified element to the top of this stack.
	 * @param element element to be pushed on stack
	 */
	public void push(T element)
	{
		LinearNode<T> temp = new LinearNode<T>(element);//instaniate the object and returns the reference with the keyword new
		if (count == capacity){ //delete the last node if the stack is full
			for  (int i = 0; i < capacity; i++)
			{
				top = top.getNext();
				if (i == capacity-1)
				{
					top = top.getNext();		
					
				}
				System.out.println("top: " + top.getElement());
				System.out.println("i: " + i);
				
			}
		
            count--;
			
        }
            temp.setNext(top);
            top = temp;
            count++;
			
	}//O(1)

	/**
	 * Removes the element at the top of this stack and returns a
	 * reference to it. 
	 * @return element from top of stack
	 * @throws EmptyCollectionException if the stack is empty
	 */
	public T pop() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("stack");

		T result = top.getElement();
		top = top.getNext();
		count--;

		return result;
	}

	/**
	 * Returns a reference to the element at the top of this stack.
	 * The element is not removed from the stack.  
	 * @return element on top of stack
	 * @throws EmptyCollectionException if the stack is empty  
	 */
	public T peek() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		if (isEmpty())
			throw new EmptyCollectionException("stack");
		T result = top.getElement();
		return result;  // temp
	}

	/**
	 * Returns true if this stack is empty and false otherwise. 
	 * @return true if stack is empty
	 */
	public boolean isEmpty()
	{
		// To be completed as a Programming Project
		if (count == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns the number of elements in this stack.
	 * @return number of elements in the stack
	 */
	public int size()
	{
		// To be completed as a Programming Project
		
		return count;  // temp
	}

	/**
	 * Returns a string representation of this stack. 
	 * @return string representation of the stack
	 */
	public String toString()
	{
		// To be completed as a Programming Project
		String result = "";
        LinearNode<T> current = top;

        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }

        return result;
    }

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack.toString());

	}

}

