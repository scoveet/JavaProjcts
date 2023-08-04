package jsjf;


/**
 * Yixin Wang
 * T00735859
 */

 //The deque interface implemented by the LinkedQueue class

public interface DequeADT <T> {
    
    /**
     * QueueADT defines the interface to a queue collection.
     *
     * @author Java Foundation
     * @version 4.0
     */
    public interface QueueADT<T>
    {
        /**  
         * Adds one element to the begnning of this queue. 
         * @param element  the element to be added to the rear of the queue  
         */
        public void enqueueHead(T element);

        /* Adds one element to the end of this queue */
        public void dequeueTail(T element);
    
        /**  
         * Removes and returns the element at the front of this queue.
         * @return the element at the front of the queue
         */
        public T dequeueHead();

        /* Removes and returns the element at the back of the queue */
        public T dequeueTail();
        
    
        /**  
         * Returns without removing the element at the front of this queue.
         * @return the first element in the queue
         */
        public T head();

        /* Returns the back element on the queue without removing it */
        public T tail();
        
    
        /**  
         * Returns true if this queue contains no elements.
         * @return true if this queue is empty
         */

        public boolean isEmpty();
    
        /**  
         * Returns the number of elements in this queue. 
         * @return the integer representation of the size of the queue
         */
        public int size();
    
        /**  
         * Returns a string representation of this queue. 
         * @return the string representation of the queue
         */
        public String toString();
    }
    
}
