package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testPeek() {
        Queue queue = new Queue(new ImmutableLinkedList(new Object[] {3, 7, 9}));
        assertEquals(3, queue.peek());
    }

    @Test
    public void testEnqueue() {
        Queue queue = new Queue(new ImmutableLinkedList(new Object[] {3, 7, 9}));
        queue.enqueue(15);
        Object[] expArr = {3, 7, 9, 15};
        assertArrayEquals(expArr, queue.getQueue().toArray());
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue(new ImmutableLinkedList(new Object[] {3, 7, 9}));
        Object[] expArr = {7, 9};
        assertEquals(3, queue.dequeue());
        assertArrayEquals(expArr, queue.getQueue().toArray());
    }
    
}
