package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void test() {
        Stack q = new Stack();
        q.push(1);
        q.push(2);
        assertEquals(2, q.peek());
        assertEquals(2, q.linkedList.getLenght());
        q.pop();
        assertEquals(1, q.peek());
        q.pop();
    }


}
