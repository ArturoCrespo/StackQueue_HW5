package edu.miracosta.cs113;

import java.util.ArrayList;

public class TestDriver {
    public static void main(String[] args) {
        ArrayListStack testStack = new ArrayListStack<String>() ;

        testStack.display();

        testStack.push("Arturo") ;
        testStack.push("Jinju") ;
        testStack.push("Alma") ;
        testStack.push("Jiji") ;

        testStack.display(); ;

        testStack.peek() ;

        System.out.println("\n" + testStack.pop()) ;

        testStack.display() ;
    }
}
