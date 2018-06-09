package popova.generics.lessonone.store;

import org.junit.Before;
import org.junit.Test;
import popova.generics.SimpleArray;
import popova.generics.lessonone.User;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    UserStore<User> userStore = new UserStore<User>(12);

    @Before
    public void setUp() {
        User user = new User("1");
        userStore.add(user);
        userStore.add(new User("2"));
        userStore.add(new User("3"));
        userStore.add(new User("4"));
    }

    @Test
    public void add() {
        assertThat(new User("1"), is(userStore.findById("1")));
        assertThat(new User("2"), is(userStore.findById("2")));
        assertThat(new User("3"), is(userStore.findById("3")));
        assertThat(new User("4"), is(userStore.findById("4")));
    }

    @Test
    public void replace() {
        assertTrue(userStore.replace("1", new User("6")));
        assertThat(new User("6"), is(userStore.findById("6")));
        assertTrue(userStore.replace("2", new User("7")));
        assertThat(new User("7"), is(userStore.findById("7")));
        assertTrue(userStore.replace("3", new User("8")));
        assertThat(new User("8"), is(userStore.findById("8")));
        assertTrue(userStore.replace("4", new User("9")));
        assertThat(new User("9"), is(userStore.findById("9")));
    }

    @Test(expected = NoSuchElementException.class)
    public void delete() {
        assertTrue(userStore.delete("1"));
        assertTrue(userStore.delete("2"));
        assertTrue(userStore.delete("3"));
        assertTrue(userStore.delete("4"));
        userStore.findById("1");
    }

    @Test(expected = NoSuchElementException.class)
    public void findById() {
        userStore.findById("22");
    }
}