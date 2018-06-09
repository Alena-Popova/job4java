package popova.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    private SimpleArray<String> strings;
    private Iterator<String> stringIterator;

    @Before
    public void setUp() {
        strings = new SimpleArray<>(10);
        strings.add(0,"First str", "Second", "Third", "Fourth");
        stringIterator = strings.iterator();
    }

    @Test
    public void testAdd() {
        assertThat(strings.add("Fifth"), is(true));
        assertThat("Fifth", is(strings.get(4)));
    }


    @Test
    public void setTest() {
        assertThat(strings.set(1, "New str"), is(true));
        assertThat("New str", is(strings.get(1)));
    }

    @Test
    public void deleteTest() {
        assertThat(strings.delete(2), is(true));
        assertThat("Fourth", is(strings.get(2)));

    }

    @Test
    public void getTest() {
        assertThat("First str", is(strings.get(0)));
        assertThat("Second", is(strings.get(1)));
        assertThat("Third", is(strings.get(2)));
        assertThat("Fourth", is(strings.get(3)));
    }

    @Test
    public void iteratorTests() {
        assertThat(stringIterator.hasNext(), is(true));
        assertThat(stringIterator.hasNext(), is(true));
        assertThat(stringIterator.next(), is(strings.get(0)));
        assertThat(stringIterator.hasNext(), is(true));
        assertThat(stringIterator.next(), is(strings.get(1)));
        assertThat(stringIterator.hasNext(), is(true));
        assertThat(stringIterator.next(), is(strings.get(2)));
        assertThat(stringIterator.hasNext(), is(true));
        assertThat(stringIterator.next(), is(strings.get(3)));
        assertThat(stringIterator.hasNext(), is(false));
    }


}