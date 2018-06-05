package popova.max;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
	
	@Test
    public void isItRightMaxValue() {
        Max couple_numbers = new Max();
        assertThat(couple_numbers.max(1,2), is(2));
    }
	
}