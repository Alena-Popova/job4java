import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashSet<E> implements Iterable<E> {

    private int modCount = 0;
    private int hashCAPACITY = 12;
    private int countInsert = 0;

    Object objects[] = new Object[hashCAPACITY];

    /**
     * Чтобы найти место объекта в таблице, вычисляется
     * его хеш-код и уменьшается его модуль до общего количества групп.
     * @param e
     * @return
     */
    public boolean add(E e) {
        checkCapacity();
        objects[Math.abs(e.hashCode() % hashCAPACITY)] = e;
        countInsert++;
        return true;
    }

    /**
     * Если не нашолся элемент в массиве то getIndex возвращает -1
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return objects[Math.abs(e.hashCode() % hashCAPACITY)] != null && objects[Math.abs(e.hashCode() % hashCAPACITY)].equals(e);
    }

    /**
     * @param e
     * @return
     */
    public boolean remove(E e) {
        boolean result = false;
        if (contains(e)) {
            objects[Math.abs(e.hashCode() % hashCAPACITY)] = null;
            result = true;
        }
        return result;
    }


    private void checkCapacity() {
        if (countInsert >= hashCAPACITY * 0.75) {
            hashCAPACITY *= 2;
            Object second[] = new Object[hashCAPACITY];
            Iterator iterator = iterator();
            while (iterator.hasNext()) {
                E value = (E) iterator.next();
                second[Math.abs(value.hashCode()%hashCAPACITY)] = value;
            }
            objects = Arrays.copyOf(second, hashCAPACITY);
        }
    }


    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            int expectedModCount = modCount;
            private int count = 0;


            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                int i = count;
                while (i < objects.length) {
                    if (objects[i] != null) {
                        result = true;
                        break;
                    }
                    i++;
                }
                count = i;
                return result;
            }

            public E next() {
                if (expectedModCount != modCount)
                    throw new ConcurrentModificationException();
                if (count >= objects.length) {
                    throw new NoSuchElementException();
                }
                return (E) objects[count++];
            }

            public void remove() {
                if (count > objects.length || count < 0) {
                    throw new IndexOutOfBoundsException();
                }
                objects[count] = null;
                count--;
                expectedModCount++;
                modCount++;
            }
        };
        return iterator;
    }
}
