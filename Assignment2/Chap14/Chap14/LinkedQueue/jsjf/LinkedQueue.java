package jsjf;

import jsjf.exceptions.*;




/**
 * LinkedQueue represents a linked implementation of a queue.
 * Yixin Wang
 * T00735859
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedQueue<T> implements DequeADT<T>
{
	private int count;
	private LinearNode<T> head, tail;

	/**
	 * Creates an empty queue.
	 */
	public LinkedQueue()
	{
		count = 0;
		head = null;//initialize the variables
		tail = null;
	}

	/**
	 * Adds the specified element to the tail of this queue.
	 * @param element the element to be added to the tail of the queue
	 */
	public void enqueueRear(T element)
	{
		LinearNode<T> node = new LinearNode<T>(element);

		if (isEmpty())
			head = node;

		else
			tail.setNext(node);
			node.setPrevious(tail);
			
			//System.out.println("next is " + node.getNext()); // if the return of next is null then this function adds the node to the rear
			

		tail = node;
		count++;
	}

	public void enqueueFront(T element)
	{
		LinearNode<T> node = new LinearNode<T>(element);

		if (isEmpty())
			tail = node;
		else
			head.setPrevious(node);
			node.setNext(head);
			//System.out.println("previous is " + node.getPrevious()); // if the return of previous is null then this function adds the node to the front 
			

		head = node;
		count++;
	}


	/**
	 * Removes the element at the head of this queue and returns a
	 * reference to it. 
	 * @return the element at the head of this queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public T dequeueHead() throws EmptyCollectionException//this dequeue operation does not remove the node, it just gets the next one
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		T result = head.getElement();
		head = head.getNext();
		count--;

		if (isEmpty())
			tail = null; 
		else
			head.setPrevious(null);//cut the link to the old head node that the new head just moved from

		return result;
	}

	public T dequeueTail() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		T result = tail.getElement();
		tail = tail.getPrevious();
		count--;

		if (count == 1){

		}

		if (isEmpty())
			head = null;
		else
			tail.setNext(null); // cute the linkes to the old tail node that the new tail just moved from

		return result;
	}

	/**
	 * Returns a reference to the element at the head of this queue.
	 * The element is not removed from the queue.  
	 * @return a reference to the first element in this queue
	 * @throws EmptyCollectionsException if the queue is empty
	 */
	public T First() throws EmptyCollectionException // the peek of the element at head
	{
		// To be completed as a Programming Project
		if (isEmpty())
		throw new EmptyCollectionException("queue"); 

		return head.getElement();  
	}

	public T Last() throws EmptyCollectionException
	{
	
		if (isEmpty())
		throw new EmptyCollectionException("queue"); 

		return tail.getElement();  //return the tail node, unless empty
	}

	/**
	 * Returns true if this queue is empty and false otherwise. 
	 * @return true if this queue is empty 
	 */
	public boolean isEmpty()
	{
		
		boolean result;
		if (count == 0)
			result = true;
		else
			result = false;
		return result;  // temp
	}

	/**
	 * Returns the number of elements currently in this queue.
	 * @return the number of elements in the queue
	 */
	public int size()
	{
		//just return the count of the nodes
		
		return count;  // temp
	}

	/**
	 * Returns a string representation of this queue. 
	 * @return the string representation of the queue
	 */
	public String toString()
	{
		//iterate through the linked lis using "next" links, concatenate the string representation of each element
		String result = "";
        LinearNode<T> current = head;

        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }

        return result;
	}

	//test driver
	// uncomment the last 2 lines of enqueueFront and enqueueRear to test 7 nodes, right now testing 5 nodes
	public static void main(String [] args){
		LinkedQueue<String> dequeQueue = new LinkedQueue<String>();
//For the driver, creating a deque of size 5, then repetitively add elements to the front, and then the rear.
//For each addition, output the contents of the deque as well as the size, front element, and last element
		dequeQueue.enqueueFront("Element 0");
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");

		dequeQueue.enqueueRear("Element 1");
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");

		dequeQueue.enqueueFront("Element -1");
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");

		dequeQueue.enqueueRear("Element 2");
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");

		dequeQueue.enqueueFront("Element -2");
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");
		/*dequeQueue.enqueueRear("Element 3");
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");*/
		
		/*dequeQueue.enqueueFront("Element -3");
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");*/



//with each removal, size, front element, last element as well as the queue itself is printed
		dequeQueue.dequeueHead();
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");
		
		dequeQueue.dequeueTail();
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");

		dequeQueue.dequeueHead();
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");

		dequeQueue.dequeueTail();
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");


		dequeQueue.dequeueHead();
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");

		/*dequeQueue.dequeueHead();
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");

		/*dequeQueue.dequeueTail();
		System.out.println(dequeQueue.toString());
		System.out.println("Size: " + dequeQueue.size());
		System.out.println("Fornt Element: " + dequeQueue.First());
		System.out.println("Last Element: " + dequeQueue.Last()+"\n\n");*/

	}
}