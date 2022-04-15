package edu.miracosta.cs113;

import java.util.ArrayList ;
import java.util.Collections;
import java.util.EmptyStackException;


public class ArrayListStack<E> implements StackInterface<E>{

    private ArrayList<E> theData ;

    public ArrayListStack() {
        theData = new ArrayList<E>() ;
    }

    @Override
    public boolean empty() {
        return theData.size() == 0 ;
    }

    @Override
    public E peek() {
        if(empty()) {
            throw new EmptyStackException() ;
        } else {
            return theData.get(theData.size() - 1) ;
        }
    }

    @Override
    public E pop() {
        if(empty()) {
            throw new EmptyStackException() ;
        } else {
            return theData.remove(theData.size() - 1) ;
        }
    }

    @Override
    public E push(E obj) {
        theData.add(obj) ;
        return obj ;
    }

    public void display() {

        if(empty()) {
            System.out.println("This stack is empty.\n") ;
            return ;
        }

        ArrayList<E> tempList = theData ;

        Collections.reverse(tempList) ;

        System.out.print("\nTop --> ") ;

        for(E obj : tempList) {
            System.out.print(obj + " ") ;
        }

        System.out.print("<-- Bottom\n");
    }
}
