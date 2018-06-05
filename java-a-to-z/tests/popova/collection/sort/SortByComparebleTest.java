package popova.collection.sort;

import org.junit.Before;
import org.junit.Test;
import popova.collection.sort.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortByComparebleTest {

    SortByCompareble sort = new SortByCompareble();
    List<User> list = Arrays.asList(
            new User("Vanya Murinov",23 ),
            new User("Manya",13 ),
            new User("Vanya Covalyov",13 )
    );


    @Test
    public void sortNameLength() {
        sort.sortNameLength(list).forEach((User u) -> System.out.println(u.toString()));
        assertThat( sort.sortNameLength(list).iterator().next(),is(new User("Manya",13)));
    }

    @Test
    public void sortByAllFields() {
        sort.sortByAllFields(list).forEach((User u) -> System.out.println(u.toString()));
        assertThat( sort.sortByAllFields(list).get(0),is(new User("Manya",13)));
    }
}