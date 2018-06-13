import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayListTest {
    SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList();

    @Before
    public void setUp() {
        int i = 99;
        while (i >=0 ) {
            simpleArrayList.add(i);
            i--;
        }
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(simpleArrayList.get(0), is(0));
        assertThat(simpleArrayList.get(77), is(77));
        assertThat(simpleArrayList.get(99), is(99));
    }

    @Test
    public void whenDeleteElementsThanGetNewFirstElement() {
        assertThat(simpleArrayList.getSize(), is(100));
        simpleArrayList.delete();
        assertThat(Integer.valueOf(1), is(simpleArrayList.get(0)));
        simpleArrayList.delete();
        simpleArrayList.delete();
        simpleArrayList.delete();
        simpleArrayList.delete();
        assertThat(Integer.valueOf(5), is(simpleArrayList.get(0)));
        assertThat(simpleArrayList.getSize(), is(95));
    }
}