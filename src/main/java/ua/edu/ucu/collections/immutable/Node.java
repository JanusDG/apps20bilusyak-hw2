package ua.edu.ucu.collections.immutable;

public class Node{
    Object data;
    Node next;

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData(){
        return data;
    }
}
