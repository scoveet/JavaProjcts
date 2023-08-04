package jsjf;

import jsjf.exceptions.*;
//import java.util.Iterator;

/**
 * Represents a linked implementation of a stack.
 *Yixin Wang 
 *T00735859
*/
public class LinkedStack<T> implements StackADT<T>
{
	private int count,capacity;  
	private LinearNode<T> top, iteratorNode; 

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
			iteratorNode = top; //set another pointer to reference to the top node. 
			for  (int i = capacity; i > 1; i--) // iterate through the stack with this for loop, starting at the top to the last element of the stack. The reason it stops at 1 is because you can no longer iterate through the first node after it has been cut off.
			{
				//System.out.println("current node: " + iteratorNode.getElement());//testing if the iteratorNode is working
				iteratorNode = iteratorNode.getNext();//iteration
				if (i == 3)//this is the line where the last node is deleted, but this.iteratorNode is null
				{
					iteratorNode.setNext(null);	//this is the line where the link to the bottom node on the stack is deleted
				}
				//System.out.println("top : " + top.getElement()); //testing if the top node is altered in the process
				//System.out.println("i: " + i);
				
			}
		
            count--;
			
        }
            temp.setNext(top); // issue #1: the top node is now null, gotta traverse back
            top = temp;
            count++;

			//System.out.println("count: " + count); // testing if the count is working after every push.
			
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
			throw new EmptyCollectionException("stack"); // if empty, return exception

		T result = top.getElement(); 
		top = top.getNext();//popping off the top stack  by setting the top node to the next node
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
		
		if (isEmpty())
			throw new EmptyCollectionException("stack"); // if empty, return exception
		T result = top.getElement(); // just return the top element
		return result;  
	}

	/**
	 * Returns true if this stack is empty and false otherwise. 
	 * @return true if stack is empty
	 */
	public boolean isEmpty()
	{
		
		if (count == 0)
			return true;
		else
			return false; //return true if emoty, false if not
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
		String result = "";
        LinearNode<T> current = top;//set the current node to the top node for iteration purposes

        while (current != null) // until the end of the stack, or linked list
        {
            result = result + current.getElement() + "\n"; // print out the element of the current node, backspace to the next line as well
            current = current.getNext(); //iteration
        }

        return result;//return the result
    }

	/*Driver Testing
	 * Comment and Uncomment the stack.push lines below to push desired elements into the stack
	 * Drop-out stack is implemented, so the stack will only hold 5 elements at a time. 
	 * The driver create a stack of size 5, first pushes 5 then 7 string elements onto the stack. Ouputs the contents of the stack as well as size() and peek() operations.
	 */
	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("Yishe #1");
		stack.push("Yasser #2");
		stack.push("Yeshmine #3");
		stack.push("Yara #4");
		stack.push("Yixin Wang #5");
		System.out.println(stack.toString());
		System.out.println("The size of the stack is: " + stack.size());
		System.out.println("This is the top of the stack: " + stack.peek());

		System.out.println("\n\nNow pushing 2 more elements onto the stack!");
		stack.push("Yishe #1");
		stack.push("Yasser #2");
		stack.push("Yeshmine #3");
		stack.push("Yara #4");
		stack.push("Yixin Wang #5");
		stack.push("Yam #6");
		stack.push("Yeisen #7");
		System.out.println(stack.toString());
		System.out.println("The size of the stack is: " + stack.size());
		System.out.println("This is the top of the stack: " + stack.peek());

	}

}

