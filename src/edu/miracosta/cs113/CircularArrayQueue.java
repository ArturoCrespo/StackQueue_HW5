package edu.miracosta.cs113;

import java.util.*;

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {

    public static final int DEFAULT_CAPACITY = 10 ;

    private int front ;

    private int rear ;

    private int size ;

    private int capacity ;

    private E[] theData ;

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY) ;
    }

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int capacity) {
        this.capacity = capacity ;
        theData = (E[]) new Object[capacity] ;
        front = 0 ;
        rear = capacity - 1 ;
        size = 0 ;
    }

    @Override
    public boolean add(E e) {
        if(size == capacity) {
            reallocate();
        }
        size++ ;
        rear = (rear + 1) % capacity ;
        theData[rear] = e ;
        return true ;
    }

    @Override
    public E element() {
        if(isEmpty()) {
            throw new NoSuchElementException() ;
        }
        return theData[front] ;
    }

    @Override
    public boolean offer(E e) {
        if(size == capacity) {
            reallocate() ;
        }
        size++ ;
        rear = (rear + 1) % capacity ;
        theData[rear] = e ;
        return true ;
    }

    @Override
    public E peek() {
        if(size == 0) {
            return null ;
        } else {
            return theData[front] ;
        }
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            return null ;
        }
        E removedElement = theData[front] ;
        front = (front + 1) % capacity ;
        size-- ;
        return removedElement ;
    }

    @Override
    public E remove() {
         if(isEmpty()) {
             throw new NoSuchElementException() ;
         }
         E removedElement = theData[front] ;
         front = (front + 1) % capacity ;
         size-- ;
         return removedElement ;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @SuppressWarnings("unchecked")
    public void reallocate() {
        int newCapacity = 2 * capacity ;
        E[] newData = (E[]) new Object[newCapacity] ;
        int j = front ;

        for(int i = 0 ; i < size ; i++) {
            newData[i] = theData[j] ;
            j = (j + 1) % capacity ;
        }
        front = 0 ;
        rear = size - 1 ;
        capacity = newCapacity ;
        theData = newData ;
    }

    //stubbed unimplemented methods below

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

}
