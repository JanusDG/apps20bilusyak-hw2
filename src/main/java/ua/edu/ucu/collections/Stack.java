package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Stack {
    public ImmutableLinkedList linkedList;

    public Stack(){
        this.linkedList = new ImmutableLinkedList();
    }
    Object peek(){
        Node node = this.linkedList.getHead();
        return node.getData();
    }// Returns the object from the top of the Stack without removing it
    Object pop(){
        Object node = peek();
        this.linkedList = this.linkedList.removeFirst();
        return node;
    }// Removes and returns the object from the top of the Stack
    void push(Object e){
        this.linkedList = this.linkedList.addFirst(e);
    } // Adds an object to the the top of the Stack

}
