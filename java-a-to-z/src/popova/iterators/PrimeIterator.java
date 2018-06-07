package popova.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {

    private int[] numbers;
    private int index = 0;

    public PrimeIterator(final int[] aNumbers) {
        numbers = aNumbers;
    }

    @Override
    public boolean hasNext() {
        int temp = index;
        while (temp < numbers.length) {
            if (isItPrimeNumber(numbers[temp])) return true;
            temp++;
        }
        return false;
    }

    @Override
    public Object next() {
        while (index < numbers.length && !isItPrimeNumber(numbers[index])) {
            index++;
        }
        if (index >= numbers.length) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }

    boolean isItPrimeNumber(int i) {
        boolean result = true;
        int count = 2;
        if (i == 1) {
            result = false;
        } else {
            while (count < i ) {
                if (i%count == 0 ) {
                    result =  false;
                    break;
                }
                count++;
            }
        }
        return result;
    }
}
