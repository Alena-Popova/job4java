package popova.iterators;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IteratorDoubleMassTest {
    IteratorDoubleMass iter = new IteratorDoubleMass(new int[][]{{1},{2,3},{4,6,7}});

    @Test
    public void hasNext() {

    }

    @Test
    public void next() {
        iter.next();
        iter.next();
        assertThat(iter.next(), is(3));
    }
}