package baseclasses;

import java.util.Iterator;

public class SimpleLinkedList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;

    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }

    public void add(E date) {
        Node<E> newLink = new Node<E>(date);
        newLink.next = first;
        this.first = newLink;
        size++;
    }

    public E delete() {
        Node<E> jump = first.next.next;
        first = first.next;
        first.next = jump;
        size--;
        return first.date;
    }

    public E get(int index) {
        Node<E> result = this.first;
        int i = 0;
        while (i < index) {
            result = result.next;
            i++;
        }
        return result.date;
    }

    public Node<E> getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            private Node<E> iteratorStep = first;
            private Node<E> previousStep = null;

            public boolean hasNext() {
                return iteratorStep != null;
            }

            public E next() {
                previousStep = iteratorStep;
                iteratorStep = iteratorStep.next;
                return previousStep.date;
            }

            public void remove() {
                if (previousStep != null && iteratorStep != null && iteratorStep.next != null) {
                    previousStep.next = iteratorStep.next;
                } else if (previousStep != null) {
                    previousStep.next = null;
                }
                size--;
            }

        };
        return iterator;
    }
}
