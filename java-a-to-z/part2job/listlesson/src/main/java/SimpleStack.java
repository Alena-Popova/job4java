import java.util.Iterator;

public class SimpleStack<T> {
    DinamicLinkedList<T> linkedList = new DinamicLinkedList<>();


    public T poll() {
        Iterator<T> iterator = linkedList.iterator();
        T result = iterator.next();
        iterator.remove();
        return result;
    }

    public void push(T value) {
        linkedList.add(value);
    }
}