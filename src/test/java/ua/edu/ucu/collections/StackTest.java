package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPeek() {
        Stack stack = new Stack(new ImmutableLinkedList(new Object[] {3, 7, 9}));
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPush() {
        Stack stack = new Stack(new ImmutableLinkedList(new Object[] {3, 7, 9}));
        stack.push(15);
        Object[] expArr = {3, 7, 9, 15};
        assertArrayEquals(expArr, stack.getStack().toArray());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack(new ImmutableLinkedList(new Object[] {3, 7, 9}));
        Object[] expArr = {3, 7};
        assertEquals(9, stack.pop());
        assertArrayEquals(expArr, stack.getStack().toArray());
    }
    
}
