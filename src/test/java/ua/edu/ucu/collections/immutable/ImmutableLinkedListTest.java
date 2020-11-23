package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testAdd() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {5, 4});

        ImmutableLinkedList list1 = linked.add(13);
        System.out.println(Arrays.toString(list1.toArray()));
        ImmutableLinkedList list2 = linked.add(1, 34);
        System.out.println(Arrays.toString(list2.toArray()));

        ImmutableLinkedList list3 = linked.addAll(new Object[] {22, 11});
        ImmutableLinkedList list4 = linked.addAll(1, new Object[] {22, 11});

        assertArrayEquals(new Object[]{5, 4, 13}, list1.toArray());
        assertArrayEquals(new Object[]{5, 34, 4}, list2.toArray());
        assertArrayEquals(new Object[]{5, 4, 22, 11}, list3.toArray());
        assertArrayEquals(new Object[]{5, 22, 11, 3}, list4.toArray());
    }



}
