package popova.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArraySortTest {

    @Test
    public void whenCoupleMassAddingThan() {
        int[] first = new int[]{1,3,5,7,9};
        int[] second = new int[]{2,4,6,8,10,12};

        ArraySort massiv = new ArraySort();
        int[] result = massiv.sort(first, second);
        assertThat(result, is(new int[]{1,2,3,4,5,6,7,8,9,10,12}));
    }

}