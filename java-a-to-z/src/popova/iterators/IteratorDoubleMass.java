package popova.iterators;

import java.util.Arrays;
import java.util.Iterator;

public class IteratorDoubleMass implements Iterator{
    private  int[] source;
    private int index = 0;
    private int limits = 0;

    public IteratorDoubleMass(int[][] sourseS) {
        index = 0;
        Arrays.stream(sourseS).forEach(x -> limits += x.length);
        source = new int[limits];
        for (int[] one : sourseS) {
            System.arraycopy(one, 0, source, index, one.length);
            index += one.length;
        }
        index = 0;
    }
    @Override
    public boolean hasNext() {
        return index < source.length;
    }

    @Override
    public Object next() {
        return source[index++];
    }
}
