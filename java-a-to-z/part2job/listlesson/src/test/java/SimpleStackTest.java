import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> stack = new SimpleStack();

    @Before
    public void setUp() {
        int i = 0;
        while (i < 10) {
            stack.push(i);
            i++;
        }
    }

    @Test
    public void poll() {
        assertThat(9, is(stack.poll()));
        assertThat(8, is(stack.poll()));
        assertThat(7, is(stack.poll()));
        assertThat(6, is(stack.poll()));
    }

    @Test
    public void push() {
    }
}