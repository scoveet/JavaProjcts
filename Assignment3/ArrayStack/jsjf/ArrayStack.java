package jsjf;

import jsjf.exceptions.*;
import java.util.ArrayList;

/**
 * An ArrayList implementation of a stack
 * 
 * @author Yixin Wang 
 * @version T00735859
 */

 
public class ArrayStack<T> implements StackADT<T>
{
	private ArrayList<T> stack = new ArrayList<T>(); //initialize stack as an ArrayList object


	public void push(T element) {//add the element to the 
		stack.add(element);
	}

	public T pop() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("stack");//if empty, throw the exception
		return stack.remove(stack.size()-1);////otherwise, remove the last element of the stack means the removal of the element at index size()-1
	}

	public T peek() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("stack");//if empty, throw the exception
		return stack.get(stack.size()-1);//otherwise, return the element at index size()-1
	}

	public int size() {
		return stack.size();//return the size of the stack
	}

	public boolean isEmpty() {
		return stack.isEmpty();//return true if the stack is empty
	}

	public String toString() {
		return stack.toString();
	}

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.print(stack+"\n");
		System.out.print("top of the stack: " + stack.peek()+"\n");
		System.out.print("empty? " + stack.isEmpty()+"\n");
		System.out.print("the size is: "+stack.size()+"\n");
		System.out.print("pop: "+stack.pop()+"\n");
		System.out.println(stack.toString());
		
	}

}

