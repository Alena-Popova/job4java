package baseclasses;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList();

    @Before
    public void setUp() {
        int i = 99;
        while (i >=0 ) {
            simpleLinkedList.add(i);
            i--;
        }
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(simpleLinkedList.get(0), is(0));
        assertThat(simpleLinkedList.get(77), is(77));
        assertThat(simpleLinkedList.get(99), is(99));
    }

}