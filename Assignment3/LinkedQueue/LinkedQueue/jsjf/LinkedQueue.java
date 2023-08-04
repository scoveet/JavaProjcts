package jsjf;

import java.util.LinkedList;
import jsjf.exceptions.*;




/**
 * LinkedQueue represents a linked implementation of a queue.
 * Yixin Wang
 * T00735859
 */
public class LinkedQueue<T> implements QueueADT<T>
{
	LinkedList<T> queue = new LinkedList<>();//create a new LinkedList object "queue"
	
	public void enqueue(T element) {
		queue.addFirst(element);//add the element to the first element of the linked list, the rear of the queue
	}

	public T dequeue() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("queue");//if the queue is empty, throw the exception
		}
		return queue.removeLast();//if the queue is not empty, remove the last element of the linked list, the front of the queue
	}

	public T first() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("queue");//if the queue is empty, throw the exception
		}
		return queue.getLast();//if the queue is not empty, return the last element of the linked list, the front of the queue
	}
	
	public boolean isEmpty() {//return true if the queue is empty
		return queue.isEmpty();
	}

	public int size() {//return the size of the queue
		return queue.size();
	}

	public String toString() {//return the queue in the form of string 
		return queue.toString();
	}

//driver test that test all the methods and print the results of each method
	public static void main(String[] args){
		LinkedQueue<Integer>queue = new LinkedQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(7);
		queue.enqueue(9);
		System.out.println(queue.toString());
		System.out.println("empty? " + queue.isEmpty());
		System.out.println("the size is: "+ queue.size());
		System.out.println("first element in the queue: "+queue.first());
		System.out.println("dequeue: " + queue.dequeue());
		System.out.println(queue.toString());
		System.out.println("empty? " + queue.isEmpty());
		System.out.println("the size is: "+ queue.size());
		System.out.println("first element in the queue: "+queue.first());
	

		

	}
}
