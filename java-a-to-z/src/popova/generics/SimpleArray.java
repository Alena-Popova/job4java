package popova.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] objects;
    private int count = 0;

    public SimpleArray( int size) {
        objects = (T[]) new Object[size];
    }

    public boolean add(T model) {
        objects[count] = model;
        return true;
    }

    public boolean set(int index, T model) {
        if (index < objects.length) {
            objects[index] = model;
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int index) {
        if (index < objects.length) {
            while (index < count) {
                objects[index] = objects[index+1];
                index++;
            }
            objects[count] = null;
            count--;
            return true;
        } else {
            return false;
        }
    }

    public T get(int index) {
        if (index < count) {
            return objects[index];
        }
        return objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < objects.length;
            }

            @Override
            public T next() {
                if (count >= objects.length) {
                    throw new NoSuchElementException();
                }
                return objects[count];
            }
        };
        return null;
    }
}
