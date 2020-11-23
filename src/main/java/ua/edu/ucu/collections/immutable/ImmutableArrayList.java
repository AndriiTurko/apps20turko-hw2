package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] objects;
    private final int size;

    public ImmutableArrayList(Object[] objects){
        this.size = objects.length;
        this.objects = objects;
    }

    public void checkIndex(int index) {
        if (index - 1 > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(size, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index);
        int newSize = size + c.length;
        Object[] newObjects = new Object[newSize];

        int i = 0;
        for (; i < index; i++) {
            newObjects[i] = objects[i];
        }
        int temp = index + c.length;
        for (; i < temp; i++) {
            newObjects[i] = c[i - index];
        }
        for (; i < newSize; i++){
            newObjects[i] = objects[i-c.length];
        }

        return new ImmutableArrayList(newObjects);
    }

    @Override
    public Object get(int index) {
        return objects[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index);
        Object[] newObjects = new Object[size-1];
        for (int i = 0; i < index; i++) {
            newObjects[i] = objects[i];
        }
        for (int i = index; i < size - 1; i++) {
            newObjects[i] = objects[i+1];
        }
        return new ImmutableArrayList(newObjects);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        objects[index] = e;
        return new ImmutableArrayList(objects);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (objects[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object[0]);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return objects;
    }
}
