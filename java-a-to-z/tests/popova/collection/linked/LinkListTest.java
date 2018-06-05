package popova.collection.linked;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkListTest {
    @Test
    public void whenHigherPrioruty() {
        LinkList queue  = new LinkList();
        queue.put(new Task("low",5));
        queue.put(new Task("urgent",1));
        queue.put(new Task("middle",10));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

}