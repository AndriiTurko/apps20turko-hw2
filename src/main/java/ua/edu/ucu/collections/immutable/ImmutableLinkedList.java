package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList{
    private final Node head;
    private final Object[] nodes;
    private final int size;

    public ImmutableLinkedList(Object[] objects) {
        this.head = new Node(null);
        Node curNode = head;
        for (Object obj: objects) {
            curNode.data = obj;
            curNode.next = new Node(null);
            curNode = curNode.next;
        }
        this.size = objects.length;
        this.nodes = objects;
    }

    public int checkIndex(int index) {
        if (index + 1 > size) {
            throw new IndexOutOfBoundsException();
        } else if (index > size) {
            return 1;
        } else { return 0; }

    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(size, e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        int checker = checkIndex(index-1);
        int newSize = size + c.length;
        Object[] newValues = new Object[newSize];
        Node tempNode = head;
        int i = 0;
        for (;i < index; i++) {
            System.out.println("i1 " + i);
            newValues[i] = tempNode.data;
            tempNode = tempNode.next;
        }
        Node saveNode = tempNode;
        int temp = index - 1 + c.length;
        for (Object obj: c) {
            System.out.println("i2 " + i);
            System.out.println(c[temp-i]);
            newValues[i] = c[temp-i];
            tempNode.next = new Node(obj);
            tempNode = tempNode.next;
            i++;
        }
        System.out.println("temp: " + tempNode.data);
        System.out.println("save " + saveNode.data);
        tempNode.next = saveNode;

        if (newValues[newSize-1] == null) {
            while (saveNode != null && i < newSize) {
                System.out.println("i3 " + i);
                System.out.println("data: " + saveNode.data);
                newValues[i] = saveNode.data;
                saveNode = saveNode.next;
                i++;
            }
        }
        System.out.println("c: " + Arrays.toString(c));
        System.out.println("objs: " + Arrays.toString(nodes));
        System.out.println("result:" + Arrays.toString(newValues));
        return new ImmutableLinkedList(newValues);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        Node curNode = head;
        int newSize = size - 1;
        Object[] newObjects = new Object[newSize];
        int i = 0;
        for (; i < index-1; i++) {
            curNode = curNode.next;
            newObjects[i] = nodes[i];
        }
        curNode.next = curNode.next.next;

        for (; i < newSize; i++) {
            newObjects[i] = nodes[i+1];
        }

        return new ImmutableLinkedList(newObjects);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        checkIndex(index);
        nodes[index] = e;
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.data = e;
        return new ImmutableLinkedList(nodes);
    }

    @Override
    public int indexOf(Object e) {
        Node curNode = head;
        for (int i = 0; i < size; i++) {
            if (curNode.data.equals(e)) {
                return i;
            }
            curNode = curNode.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList(new Object[0]);
    }

    @Override
    public boolean isEmpty() {
        return (head.data == null);
    }

    @Override
    public Object[] toArray() { return nodes; }

    public ImmutableLinkedList addFirst(Object e) { return add(0, e); }

    public ImmutableLinkedList addLast(Object e) {
        return add(size-1, e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }
    public ImmutableLinkedList removeLast() {
        return remove(size - 1);
    }

}
