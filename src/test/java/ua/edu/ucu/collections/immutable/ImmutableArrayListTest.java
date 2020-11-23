package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testAddRemove() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        for (int i = 0; i < 4; i++) {
            arrayList = arrayList.add(i);
        }
        assertEquals("0, 1, 2, 3, ", arrayList.toString());
        arrayList = arrayList.add(4);
        assertEquals("0, 1, 2, 3, 4, ", arrayList.toString());
        arrayList = arrayList.add(0,0);
        assertEquals("0, 0, 1, 2, 3, 4, ", arrayList.toString() );

        Object[] c = {5,6};
        arrayList = arrayList.addAll(c);
        assertEquals("0, 0, 1, 2, 3, 4, 5, 6, ", arrayList.toString() );
        arrayList = arrayList.addAll(0, c);
        assertEquals("6, 5, 0, 0, 1, 2, 3, 4, 5, 6, ", arrayList.toString() );


        arrayList = arrayList.remove(0);
        arrayList = arrayList.remove(0);
        arrayList = arrayList.remove(0);
        assertEquals("0, 1, 2, 3, 4, 5, 6, ", arrayList.toString() );

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
    

