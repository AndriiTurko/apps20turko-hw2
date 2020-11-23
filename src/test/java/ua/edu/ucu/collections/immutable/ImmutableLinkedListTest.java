package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testAdd() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {5, 4});

        ImmutableLinkedList list1 = linked.add(13);
        ImmutableLinkedList list2 = linked.add(1, 34);
        ImmutableLinkedList list3 = linked.addAll(new Object[] {22, 11});
        ImmutableLinkedList list4 = linked.addAll(1, new Object[] {22, 11});

        assertArrayEquals(new Object[]{5, 4, 13}, list1.toArray());
        assertArrayEquals(new Object[]{5, 34, 4}, list2.toArray());
        assertArrayEquals(new Object[]{5, 4, 22, 11}, list3.toArray());
        assertArrayEquals(new Object[]{5, 22, 11, 4}, list4.toArray());
    }

    @Test
    public void testGet() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {5, 4});

        assertEquals(4, linked.get(1));
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {5, 4});

        ImmutableLinkedList list1 = linked.remove(0);

        assertArrayEquals(new Object[]{4}, list1.toArray());
    }

    @Test
    public void testSet() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {5, 4});

        ImmutableLinkedList list1 = linked.set(0, 6);

        assertArrayEquals(new Object[]{6, 4}, list1.toArray());
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {5, 4});

        assertEquals(1, linked.indexOf(4));
    }

    @Test
    public void testSize() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {5, 4});

        assertEquals(2, linked.size());
    }

    @Test
    public void testClearAndIsEmpty() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {5, 4});

        ImmutableLinkedList list1 = linked.clear();

        assertArrayEquals(new Object[]{}, list1.toArray());
        assertEquals(true, list1.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {4, 5, 6});

        assertArrayEquals(new Object[]{4, 5, 6}, linked.toArray());
    }


    @Test
    public void testExtra() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {4, 5, 6});

        ImmutableLinkedList list1 = linked.addFirst(1);

        assertArrayEquals(new Object[]{1, 4, 5, 6}, list1.toArray());

        list1 = list1.addLast(10);

        assertArrayEquals(new Object[]{1, 4, 5, 6, 10}, list1.toArray());

        assertEquals(4, linked.getFirst());

        assertEquals(6, linked.getLast());

        linked = linked.removeFirst();

        assertArrayEquals(new Object[]{5, 6}, linked.toArray());

        linked = linked.removeLast();

        assertArrayEquals(new Object[]{5}, linked.toArray());

    }

}
