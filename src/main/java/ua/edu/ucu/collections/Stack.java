package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack(ImmutableLinkedList stack)
    {
        this.stack = stack;
    }

    public ImmutableLinkedList getStack()
    {
        return this.stack;
    }

    public Object peek()
    {
        return stack.getFirst();
    }

    public Object pop()
    {
        Object first = stack.getLast();
        stack = stack.removeLast();
        return first;
    }

    public void push(Object obj)
    {
        stack = stack.addLast(obj);
    }
}