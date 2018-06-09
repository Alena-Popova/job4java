package popova.collectionspro;

public class SimpleArrayList<E> {
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
        Node<E> newLink = new Node<>(date);
        newLink.next = first;
        this.first = newLink;
        size++;
    }

    public E delete() {
        Node<E> jump = first.next.next;
        System.out.println(first.date + "- " + first.next.date.toString());
        first = first.next;
        first.next = jump;
        size--;
        System.out.println(first.date + "- " + first.next.date.toString());
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

    public int getSize() {
        return size;
    }
}
