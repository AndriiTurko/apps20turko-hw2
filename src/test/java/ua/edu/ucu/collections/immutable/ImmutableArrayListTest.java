package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        ImmutableArrayList linked = new ImmutableArrayList(new Object[] {5, 4});

        ImmutableArrayList list1 = linked.add(13);
        System.out.println(Arrays.toString(list1.toArray()));
        ImmutableArrayList list2 = linked.add(1, 34);
        System.out.println(Arrays.toString(list2.toArray()));

        ImmutableArrayList list3 = linked.addAll(new Object[] {22, 11});
        System.out.println(Arrays.toString(list3.toArray()));

        ImmutableArrayList list4 = linked.addAll(1, new Object[] {22, 11});
        System.out.println(Arrays.toString(list4.toArray()));


        assertArrayEquals(new Object[]{5, 4, 13}, list1.toArray());
        assertArrayEquals(new Object[]{5, 34, 4}, list2.toArray());
        assertArrayEquals(new Object[]{5, 4, 22, 11}, list3.toArray());
        assertArrayEquals(new Object[]{5, 22, 11, 4}, list4.toArray());
    }



}
