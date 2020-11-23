package ua.edu.ucu.collections.immutable;

import java.util.EmptyStackException;

public class ImmutableLinkedList{
    private final Node head;
    private final Node tail;

    public ImmutableLinkedList(){
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.next = this.tail;
    }

    ImmutableLinkedList(Node curNode){
        this.head = curNode;
        while (curNode.data != null){
            curNode = curNode.next;
        }
        this.tail = curNode;
    }

    public int getLenght(){
        Node iterNode = this.head;
        int i = 0;
        while (iterNode.data != null){
            iterNode = iterNode.next;
            i++;
        }
        return i;
    }

    public ImmutableLinkedList add(Object e){
        return this.addLast(e);
    } //додає елемент у кінець колекції


    ImmutableLinkedList insert(int index, Object e) throws IllegalArgumentException {
        int lenght = this.getLenght();
        if (lenght == 0){
            throw new IllegalArgumentException();
        }

        if (index == 0){
            Node newHead = new Node(e, this.head);
            return new ImmutableLinkedList(newHead);
        }

        Node newHead = new Node(head.data, null);

        Node currIterator = newHead;
        Node currentNode = head;

        for (int i = 0; i < index; i++){
            currIterator.next = new Node(currentNode.next.data, null);
            currentNode = currentNode.next;
            currIterator = currIterator.next;
        }

        currIterator.next = new Node(e, currentNode.next);

        return new ImmutableLinkedList(newHead);

    }

    ImmutableLinkedList add(int index, Object e) throws IllegalArgumentException {
        return this.insert(index, e);
    } //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    ImmutableLinkedList addAll(Object[] c){
        ImmutableLinkedList newList = new ImmutableLinkedList(this.head);
        for (Object obj:c){
            newList = newList.addLast(obj);
        }
        return newList;
    }//додає масив елементів у кінець колекції
//
    ImmutableLinkedList addAll(int index, Object[] c) throws IllegalArgumentException{
        if (index >= this.getLenght()){
            throw new IllegalArgumentException();
        }
        ImmutableLinkedList newList = new ImmutableLinkedList(this.head);
        for (Object obj:c){
            newList = newList.insert(index, obj);
        }
        return newList;
    } // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
//
    Object get(int index) throws IllegalArgumentException{ //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
        if (index >= this.getLenght()){
            throw new IllegalArgumentException();
        }
        int i = 0;
        Node iterNode = this.head.next;
        while (iterNode.data != null){
            if (i == index){
                return iterNode.data;
            }
            iterNode = iterNode.next;
            i++;
        }
        return null;
    }
    ImmutableLinkedList remove(int index) throws IllegalArgumentException{//видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

        if (index >= this.getLenght()){
            throw new IllegalArgumentException();
        }
        if (index == 0){
            return  new ImmutableLinkedList(this.head.next);
        }

        Node newHead = new Node(head.data, null);

        Node currIterator = newHead;
        Node currentNode = head;

        for (int i = 0; i < index - 1; i++){
            currIterator.next = new Node(currentNode.next.data, null);
            currentNode = currentNode.next;
            currIterator = currIterator.next;
        }

        currIterator.next = currentNode.next.next;

        return new ImmutableLinkedList(newHead);


    } //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    int indexOf(Object e){

        int i = 0;
        Node iterNode = this.head.next;
        while (iterNode.data != null){
            if (e == iterNode.data){
                return i;
            }
            iterNode = iterNode.next;
            i++;
        }

        return -1;
    }//шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)
//
    int size(){return this.getLenght();} //розмір колекції
//
    ImmutableLinkedList clear(){
        return (new ImmutableLinkedList());
    } //очищує вміст колекції
//
    boolean isEmpty(){
        return this.getLenght() == 0;
    } //якщо у колеції нема елементів то повертає true
//
    Object[] toArray(){
        Object[] toReturn = new Object[this.getLenght()];
        Node iterNode = this.head.next;
        int i = 0;
        while (iterNode.data != null){
            toReturn[i] = iterNode.data;
            iterNode = iterNode.next;
            i ++;
        }
        return toReturn;
    } //перетворює колекцію до масиву обєктів

    @Override
    public String toString(){
        Node curHead = head;
        StringBuilder rez = new StringBuilder();
        while (curHead.data != null){
            rez.append(curHead.data.toString()).append(", ");
            curHead = curHead.next;
        }
        return rez.toString();
    }//повертає рядок, де через кому відображаютсься елементи колекції

    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }

    public Node getTailThroughHead(Node curNode){
        while (curNode.data != null){
            curNode = curNode.next;
        }
        return curNode;
    }

    public ImmutableLinkedList addFirst(Object e){
        Node nodeToAdd = new Node(e, this.head);

        return new ImmutableLinkedList(nodeToAdd);
    } // додає елемент у початок зв'язаного списку

    public ImmutableLinkedList addLast(Object e){

        Node curTail = this.getTailThroughHead(this.head);
        curTail.data = e;
        curTail.next = new Node(null, null);
        Node curHead = this.head;

        return new ImmutableLinkedList(curHead);
    } // додає елемент у кінець зв'язаного списку
//
    public Object getFirst(){
        return this.head.next.data;
    }
//
    public Object getLast(){
        Node head = this.head;

        while (head.next.data != null){
            head = head.next;
        }
        return head.data;
    }
//
    public ImmutableLinkedList removeFirst() throws EmptyStackException {
        if (this.getLenght() == 0){
            throw new EmptyStackException();
        }

        Node curHead = this.head;

        return new ImmutableLinkedList(curHead.next);
    } // видаляє перший елемент


    public ImmutableLinkedList removeLast() throws EmptyStackException {
        int lenght = this.getLenght();
        if (lenght == 0){
            throw new EmptyStackException();
        }
        Node newHead = new Node(head.data, null);

        Node currIterator = newHead;
        Node currentNode = head;

        for (int i = 0; i < lenght - 2; i++){
            currIterator.next = new Node(currentNode.next.data, null);
            currentNode = currentNode.next;
            currIterator = currIterator.next;
        }
        currIterator.next = new Node(null, null);

        return new ImmutableLinkedList(newHead);

    }// видаляє останній елемент

}
