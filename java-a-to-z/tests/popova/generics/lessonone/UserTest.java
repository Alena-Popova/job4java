package popova.generics.lessonone;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    User user = new User("1");

    @Test
    public void getId() {
        assertThat("1", is(user.getId()));
    }

    @Test
    public void equals() {
    }

}