package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] objects;
    private final int size;

    public ImmutableArrayList(Object[] objects){
        this.size = objects.length;
        this.objects = objects;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(size-1, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size-1, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        int newSize = size + c.length;
        Object[] newObjects = new Object[newSize];
        int i = 0;
        for (; i < index; i++) {
            newObjects[i] = objects[i];
        }
        int temp = index + c.length;
        for (;i < temp; i++) {
            newObjects[i] = c[temp-i];
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
        for (int i = index; i < size - 1; i++) {
            objects[i] = objects[i+1];
        }
        return new ImmutableArrayList(objects);
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
