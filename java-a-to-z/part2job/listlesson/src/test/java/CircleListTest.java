import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CircleListTest {

    CircleList<Integer> circleList = new CircleList();
    CircleList.Node first = new CircleList.Node(1);

    @Before
    public void setUp() {
        CircleList.Node two = new CircleList.Node(2);
        CircleList.Node third = new CircleList.Node(3);
        CircleList.Node four = new CircleList.Node(4);
        CircleList.Node end = new CircleList.Node(5);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = end;
        end.next = first;
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertTrue(circleList.hasCycle(first));
    }

}