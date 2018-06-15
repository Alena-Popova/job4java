import baseclasses.SimpleList;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleListTest {

    SimpleList<Integer> simpleList = new SimpleList();

    @Before
    public void setUp() {
        int i = 0;
        while (i < 10) {
            simpleList.add(i);
            i++;
        }
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(simpleList.get(0), is(0));
        assertThat(simpleList.get(5), is(5));
        assertThat(simpleList.get(9), is(9));
    }

    @Test
    public void whenDeleteElementsThanGetNewFirstElement() {
        Iterator<Integer> integerIterator = simpleList.iterator();
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(0, is(simpleList.get(0)));
        assertThat(1, is(simpleList.get(1)));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldReturnEvenNumbersSequentially () {
        Iterator<Integer> integerIterator = simpleList.iterator();
        Iterator<Integer> integerIterator1 = simpleList.iterator();
        assertTrue(integerIterator.hasNext());
        assertTrue(integerIterator1.hasNext());
        integerIterator.remove();
        integerIterator1.hasNext();

    }
}