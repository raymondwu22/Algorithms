package datastructures.queues;
import java.util.Iterator;

public class Queue <T> implements Iterable <T> {
    private java.util.LinkedList <T> list = new java.util.LinkedList<T>();

    // Create an empty Queue
    public Queue() { }

    // Create a Queue with an initial element
    public Queue(T firstElem) {
        offer(firstElem);
    }

    // return the number of elements in the queue
    public int size() {
        return list.size();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // add and element to the back of the queue
    public void offer(T elem) {
        list.addLast(elem);
    }

    // Poll the element at the front of the queue
    // Throws an exception if the queue is empty
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty!");
        }
        return list.removeFirst();
    }

    // Peek the element at the front of the queue
    // Throws an exception if the queue is empty
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty!");
        }
        return list.peekFirst();
    }

    // Allows users to iterate through the queue using an iterator
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}

