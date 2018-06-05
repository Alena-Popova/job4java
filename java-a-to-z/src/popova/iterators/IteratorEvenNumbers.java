package popova.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorEvenNumbers implements Iterator {
    private  int[] source;
    private int index = 0;

    public IteratorEvenNumbers(int[] sourseS) {
        this.source = sourseS;

    }
    @Override
    public boolean hasNext() {
        int temp = 0;
        while (index + temp < source.length) {
            if (source[index + temp]%2 == 0) return true;
            temp++;
        }
        return false;
    }

    @Override
    public Object next() {
        while (index < source.length && source[index]%2 != 0) {
            index++;
        }
        if (index < source.length) {
            return source[index++];
        } else {
            throw new NoSuchElementException();
        }
    }
}
