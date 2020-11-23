package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testGetLenght() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        for (int i = 0; i < 9; i++){
            linkedList.addLast(i);
        }
        assertEquals(9, linkedList.getLenght());
    }

    @Test
    public void testGetString() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        for (int i = 0; i < 9; i++) {
            linkedList.addLast(i);
        }
        assertEquals("0, 1, 2, 3, 4, 5, 6, 7, 8, ", linkedList.toString());
    }

    @Test
    public void testAddRemove() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        for (int i = 0; i < 4; i++) {
            linkedList = linkedList.addLast(i);
        }
//        assertEquals("1, 2, 3, 4, 5, 6, 7, 8, ", linkedList.toString());
        linkedList = linkedList.add(4);
        assertEquals("0, 1, 2, 3, 4, ", linkedList.toString());
        linkedList = linkedList.add(0,0);
        assertEquals("0, 0, 1, 2, 3, 4, ", linkedList.toString() );

        Object[] c = {5,6};
        linkedList = linkedList.addAll(c);
        assertEquals("0, 0, 1, 2, 3, 4, 5, 6, ", linkedList.toString() );
        linkedList = linkedList.addAll(0, c);
        assertEquals("6, 5, 0, 0, 1, 2, 3, 4, 5, 6, ", linkedList.toString() );

        linkedList = linkedList.addFirst(0);
        assertEquals("0, 6, 5, 0, 0, 1, 2, 3, 4, 5, 6, ", linkedList.toString() );

         linkedList = linkedList.addLast(7);
        assertEquals("0, 6, 5, 0, 0, 1, 2, 3, 4, 5, 6, 7, ", linkedList.toString() );

        linkedList = linkedList.remove(1);
        linkedList = linkedList.remove(1);
        linkedList = linkedList.remove(1);
        assertEquals("0, 0, 1, 2, 3, 4, 5, 6, 7, ", linkedList.toString() );
        linkedList = linkedList.removeFirst();
        assertEquals("0, 1, 2, 3, 4, 5, 6, 7, ", linkedList.toString() );
        linkedList = linkedList.removeLast();
        linkedList = linkedList.removeLast();
        linkedList = linkedList.removeLast();
        assertEquals("0, 1, 2, 3, 4, ", linkedList.toString() );

    }

    @Test
    public void testInsert() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        for (int i = 1; i < 4; i++) {
            linkedList.addLast(i);
        }
        linkedList = linkedList.insert(0, 0);
        assertEquals("0, 1, 2, 3, ", linkedList.toString() );

    }
}

