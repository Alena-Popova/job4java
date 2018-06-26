import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicLinkedList<E> implements Iterable<E> {

    private Node<E> first;
    private int modCount = 0;
    private int size = 0;

    public static class Node<E> {
        E date = null;
        Node<E> next = null;
        Node<E> previous = null;

        Node(E date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "date=" + date.toString()
                    + '}';
        }
    }

    public void add(E value) {
        Node<E> newLink = new Node<E>(value);
        if (this.first == null) {
            this.first = newLink;
            this.first.next = null;
        } else {
            this.first.previous = newLink;
            newLink.next = first;
            this.first = newLink;
        }
        size++;
    }

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = this.first;
        int i = size - 1;
        while (i != index) {
            result = result.next;
            i--;
        }
        return result.date;
    }

    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int step = size - 1;
        Node<E> result = this.first;
        while (step != index) {
            result = result.next;
            step--;
        }
        replaseReference(result);
        size--;
        return result.date;
    }

    public int getSize() {
        return size;
    }

    private void replaseReference(Node<E> ref) {
        if (ref.next != null) {
            ref.next.previous = ref.previous;
        }
        if (ref.previous != null) {
            ref.previous.next = ref.next;
        } else {
            first = ref.next;
        }
    }

    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            private Node<E> iteratorStep = first;
            private Node<E> previousStep = null;
            int expectedModCount = modCount;

            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iteratorStep != null;
            }

            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                previousStep = iteratorStep;
                iteratorStep = iteratorStep.next;
                return previousStep.date;
            }

            public void remove() {
                replaseReference(previousStep);
                modCount++;
                expectedModCount++;
                size--;
            }

        };
        return iterator;
    }


}
