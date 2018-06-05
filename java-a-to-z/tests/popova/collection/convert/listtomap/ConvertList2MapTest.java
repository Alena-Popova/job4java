package popova.collection.convert.listtomap;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertList2MapTest {
    ConvertList2Map users = new ConvertList2Map();
    List<User> list = Arrays.asList(
            new User(33, "Moscow","Vanya"),
            new User(0, "Moscow","Manya"),
            new User(11, "Moscow","Sonya")
    );

    @Test
    public void whenConvertList4ToMap() {
        HashMap<Integer, User> custumers =  users.process(list);
        assertThat(custumers.values().iterator().next(), is(new User(0, "Moscow","Manya")));
    }

    @Test
    public void whenSortUsersList() {
        Iterator<User> iter = users.sort(list).iterator();
        assertThat(iter.next(), is(new User(0, "Moscow","Manya")));
   }

}