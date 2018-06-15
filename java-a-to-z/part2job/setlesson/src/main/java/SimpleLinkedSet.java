import baseclasses.SimpleLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleLinkedSet<E> extends SimpleLinkedList<E> {

    private boolean isRepeatInMySet(E value) {
        boolean result = false;
        for(int i = 0; i < super.getSize(); i++) {
            if (this.get(i).equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void add(E value) {
        if (!isRepeatInMySet(value))
            super.add(value);
    }

}
