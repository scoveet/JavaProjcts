package jsjf;

import jsjf.exceptions.*;
import java.util.Arrays;

/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 * 
 * @author Java Foundations
 * @version 4.0
 */

 /**Yixin Wang 
  *	T00735859
  */
public class ArrayStack<T> implements StackADT<T>
{
	private final static int DEFAULT_CAPACITY = 100;

	private int top;  
	private T[] stack;

	/**
	 * Creates an empty stack using the default capacity.
	 */
	public ArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty stack using the specified capacity.
	 * @param initialCapacity the initial size of the array 
	 */
	public ArrayStack(int initialCapacity)
	{
		top = -1; //changed top to -1 so after the push operation top will be the counter of the array
		stack = (T[])(new Object[initialCapacity]);

	}



	/**
	 * Adds the specified element to the top of this stack, expanding
	 * the capacity of the array if necessary.
	 * @param element generic element to be pushed onto stack
	 */

	public void push(T element)
	{
		if (size() == stack.length) 
			expandCapacity();//double the size of the array.Copies the elements in the array to a larger array, its becasue deleting the array in the memory is more troublesome than allocation more memory.
		top++; //the index of the top element in the stack will be 1 up from before
		stack[top] = element;// note that stack[top] is the actual top of the stack, push the element to the index top at the stack.

		
		
	}

	/**
	 * Creates a new array to store the contents of this stack with
	 * twice the capacity of the old one.
	 */
	private void expandCapacity()
	{
		stack = Arrays.copyOf(stack, stack.length * 2);   //double the size of the array.Copies the elements in the array to a larger array, its becasue deleting the array in the memory is more troublesome than allocation more memory.
	}

	/**
	 * Removes the element at the top of this stack and returns a
	 * reference to it. 
	 * @return element removed from top of stack
	 * @throws EmptyCollectionException if stack is empty 
	 */
	public T pop() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("stack");

		T result = stack[top];
		stack[top] = null; 
		top--; //top acting as the counter variable, so after pop, the top will be 1 down from before

		return result;
	}

	/**
	 * Returns a reference to the element at the top of this stack.
	 * The element is not removed from the stack.  
	 * @return element on top of stack
	 * @throws EmptyCollectionException if stack is empty
	 */
	public T peek() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("stack");

		return stack[top]; //now, top is the actual index of the element in the stack, started from -1 to 0, not 0 to 1
	}

	/**
	 * Returns true if this stack is empty and false otherwise. 
	 * @return true if this stack is empty
	 */
	public boolean isEmpty()
	{
		// To be completed as a Programming Project
		return (top == -1);  // temp
	}

	/**
	 * Returns the number of elements in this stack.
	 * @return the number of elements in the stack
	 */
	public int size()
	{
		// To be completed as a Programming Project
		
		//System.out.println("top of the array is: " + top);
		return top + 1;  // size is one up from the index of the array
		
	}

	/**
	 * Returns a string representation of this stack. 
	 * @return a string representation of the stack
	 */
	public String toString()
	{
		// To be completed as a Programming Project		
		String result = "";

        for (int scan=0; scan <= top; scan++) // now, as top is the index and the counter of the array, scan to the value of top to reach the top of the stack
             result = result + stack[scan] + "\n";

        return result;
	}

//driver test that demostrates all methods that I modified
public static void main(String[] args) {
	ArrayStack<String> stack = new ArrayStack<String>();
	stack.push("Jason #1");
	stack.push("Jack #2");
	stack.push("John #3");
	stack.push("Jarvis #4");
	stack.push("Yixin Wang #5");
	stack.push("Jimmy #6");
	stack.push("Jacky Chen #7");
	stack.pop();
	
	System.out.println(); //top is the index of the array, so it is 6
	System.out.println("The size of the stack is: " + stack.size());
	System.out.println("This is the top of the stack: " + stack.peek());
	System.out.println("variable 'top' after modified to be the counter: " + stack.size());

	
	System.out.println("\nMethods modified testing: \nIs the stack empty? " + stack.isEmpty());
	//System.out.println("\nPop the top element: " + stack.pop());
	System.out.println(stack.toString());
}
}

