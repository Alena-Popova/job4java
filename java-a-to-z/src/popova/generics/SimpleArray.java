package popova.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] objects;
    private int count = 0;

    public SimpleArray(int size) {
        objects = (T[]) new Object[size];
    }

    public boolean add(int index, T... model) {
        if (model.length > objects.length - index) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        while (i < model.length) {
            objects[index++] = model[i];
            i++;
        }
        count = index;
        return true;
    }

    public boolean add(T model) {
        if (count > objects.length) {
            throw new IndexOutOfBoundsException();
        }
        objects[count++] = model;
        return true;
    }

    public boolean set(int index, T model) {
        if (index > objects.length) {
            throw new IndexOutOfBoundsException();
        }
        objects[index] = model;
        return true;
    }

    public boolean delete(int index) {
        if (index > objects.length) {
            throw new IndexOutOfBoundsException();
        }
        while (index < count) {
            objects[index] = objects[index + 1];
            index++;
        }
        objects[count] = null;
        count--;
        return true;

    }

    public T get(int index) {
        if (index > objects.length) {
            throw new NullPointerException();
        }
        return objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private int count = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                int i = count;
                if (count < objects.length) {
                    while (i < objects.length) {
                        if (objects[count] != null) {
                            result = true;
                            break;
                        }
                        i++;
                    }
                }
                return result;
            }

            @Override
            public T next() {
                if (count >= objects.length) {
                    throw new NoSuchElementException();
                }
                return objects[count++];
            }
        };
        return iterator;
    }
}
