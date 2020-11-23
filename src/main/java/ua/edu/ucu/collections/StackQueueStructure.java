package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public abstract class StackQueueStructure {

    Object peek(ImmutableLinkedList list){
        Node node = list.getHead();
        return node.getData();
    }// Returns the object from the top of the Structure without removing it

    Object pop(ImmutableLinkedList list){
        Object node = peek(list);
        list.removeFirst();
        return node;
    }// Removes and returns the object from the top of the Structure
    abstract void push(Object e); // Adds an object to the the top of the Structure
}
