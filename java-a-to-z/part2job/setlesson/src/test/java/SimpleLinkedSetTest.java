import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedSetTest {
    SimpleLinkedSet<Integer> linkedSet = new SimpleLinkedSet();

    @Before
    public void setUp() {
        int i = 9;
        while (i >= 0) {
            linkedSet.add(i);
            i--;
        }
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(linkedSet.get(0), is(0));
        assertThat(linkedSet.get(5), is(5));
        assertThat(linkedSet.get(9), is(9));
    }

    @Test
    public void whenDeleteElementsThanGetNewFirstElement() {
        Iterator<Integer> integerIterator = linkedSet.iterator();
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(0, is(linkedSet.get(0)));
        assertThat(1, is(linkedSet.get(1)));
    }
}