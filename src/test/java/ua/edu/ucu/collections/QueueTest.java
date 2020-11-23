package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testQueue() {
        Queue q = new Queue();
        q.push(1);
        q.push(2);
        assertEquals(1, q.peek());
        assertEquals(2, q.linkedList.getLenght());
        q.pop();
        assertEquals(2, q.peek());
        q.pop();
    }
    
}
