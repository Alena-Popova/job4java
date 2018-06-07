package popova.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        Iterator<Integer> it;
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        IteratorOfIterators IteratorOfIterators = new IteratorOfIterators();
        it = IteratorOfIterators.convert(its);
        System.out.println(it.next());
    }
}
