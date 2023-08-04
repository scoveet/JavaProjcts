package jsjf;

import jsjf.exceptions.*;
import java.util.LinkedList;

/**
 * LinkedList implementation of a stack.
 * 
 * @author Yixin Wang 
 * T00735859
 */


public class LinkedStack<T> implements StackADT<T>{
	private LinkedList<T> stack = new LinkedList<T>();//initialize the object stack under LinkedList

	public void push(T element) {//add the element to the end of he list, top of the stack
		stack.addLast(element);
	}

	public T pop() throws EmptyCollectionException {
		if (isEmpty())//if the stack is empty, throw the exception
			throw new EmptyCollectionException("stack");
		return stack.removeLast();//if the stack is not empty, remove the last element of the list, top of the stack
	}

	public T peek() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("stack");//if the stack is empty, throw the exception
		return stack.getLast();//return the last element of the list, top of the stack
	}

	public int size() {
		return stack.size();//return the size of the stack
	}

	public boolean isEmpty() {
		return stack.isEmpty();//return true if the stack is empty
	}

	public String toString() {
		return stack.toString();//return the string of the stack
	}

	//driver test all the methods, and print the results of each method.
	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		
		System.out.print(stack+"\n");
		System.out.print("top of the stack: " + stack.peek()+"\n");
		System.out.print("empty? " + stack.isEmpty()+"\n");
		System.out.print("the size is: "+stack.size()+"\n");
		System.out.print("pop: "+stack.pop()+"\n");
		System.out.println(stack.toString());
	}
}