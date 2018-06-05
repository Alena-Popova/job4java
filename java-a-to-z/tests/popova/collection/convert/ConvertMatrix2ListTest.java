package popova.collection.convert;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertListOf2MassTo1List() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        List<int[]> input = Arrays.asList(
                new int[]{1, 4}, new int[]{2, 7}, new int[]{3, 8},new int[]{5, 10}
        );
        List<Integer> expect = Arrays.asList(
                1, 4, 2, 7, 3, 8, 5, 10
        );
        List<Integer> result = list.convert(input);
        assertThat(result, is(expect));
    }
}