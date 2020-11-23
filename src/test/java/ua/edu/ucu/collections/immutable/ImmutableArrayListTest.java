package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {5, 4});

        ImmutableArrayList list1 = linked.add(13);
        ImmutableArrayList list2 = linked.add(1, 34);
        ImmutableArrayList list3 = linked.addAll(new Object[] {22, 11});
        ImmutableArrayList list4 = linked.addAll(1, new Object[] {22, 11});

        assertArrayEquals(new Object[]{5, 4, 13}, list1.toArray());
        assertArrayEquals(new Object[]{5, 34, 4}, list2.toArray());
        assertArrayEquals(new Object[]{5, 4, 22, 11}, list3.toArray());
        assertArrayEquals(new Object[]{5, 22, 11, 4}, list4.toArray());
    }

    @Test
    public void testGet() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {5, 4});

        assertEquals(4, linked.get(1));
    }

    @Test
    public void testRemove() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {5, 4});

        ImmutableArrayList list1 = linked.remove(0);

        assertArrayEquals(new Object[]{4}, list1.toArray());
    }

    @Test
    public void testSet() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {5, 4});

        ImmutableArrayList list1 = linked.set(0, 6);

        assertArrayEquals(new Object[]{6, 4}, list1.toArray());
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {5, 4});

        assertEquals(1, linked.indexOf(4));
    }

    @Test
    public void testSize() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {5, 4});

        assertEquals(2, linked.size());
    }

    @Test
    public void testClearAndIsEmpty() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {5, 4});

        ImmutableArrayList list1 = linked.clear();

        assertArrayEquals(new Object[]{}, list1.toArray());
        assertEquals(true, list1.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {4, 5, 6});

        assertArrayEquals(new Object[]{4, 5, 6}, linked.toArray());
    }



}
