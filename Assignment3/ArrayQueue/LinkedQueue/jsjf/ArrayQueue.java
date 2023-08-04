package jsjf;
import java.util.ArrayList;
import jsjf.exceptions.*;


public class ArrayQueue<T> implements QueueADT<T>//implement the interface QueueADT with ArrayList class
{
    private ArrayList<T> queue = new ArrayList<T>();//initialize the object queue under ArrayList
    private int front, rear; //varible that counts the index of the front and rear of the queue

    public void enqueue(T element) {
        if (isEmpty()){//if empty, initialize front index and rear index of the queue to zero.
            front = rear = 0;
            queue.add(rear, element);//then, add the element to the rear of the queue
            rear++;//increment the rear index by 1, to the next position
        }
        else{
        queue.add(rear, element);//otherwise just add the element at the rear of the queue and increment the rear index by 1
        rear++;
        }
    }

    public T dequeue() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("queue");//if empty, throw the exception
        else{
        T element = queue.get(front);//otherwise, get the element at the front of the queue, and remove it from the queue, then decrement the rear index by 1
        queue.remove(front);
        rear--;
        return element;
        }
    }
    
    public T first() throws EmptyCollectionException {
        if (isEmpty()){
            throw new EmptyCollectionException("queue");//if empty, throw the exception
        }
        else{
            return queue.get(front);//otherwise, return the element at the front of the queue
        }
    }

    public boolean isEmpty() {//return true if the queue is empty
        return queue.isEmpty();
    }

    public int size() {//return the size of the queue
        return queue.size();
    }

    public String toString(){//return the queue in the form of string
        return queue.toString();
    }

    //driver test that test all the methods and print the results of each method
    public static void main(String[] args){
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
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
