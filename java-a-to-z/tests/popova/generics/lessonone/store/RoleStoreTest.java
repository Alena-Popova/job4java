package popova.generics.lessonone.store;

import org.junit.Before;
import org.junit.Test;
import popova.generics.lessonone.Role;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    RoleStore<Role> roleStore = new RoleStore<>(12);

    @Before
    public void setUp() {
        roleStore.add(new Role("1"));
        roleStore.add(new Role("2"));
        roleStore.add(new Role("3"));
        roleStore.add(new Role("4"));
    }
    @Test
    public void add() {
        assertThat(new Role("1"), is(roleStore.findById("1")));
        assertThat(new Role("2"), is(roleStore.findById("2")));
        assertThat(new Role("3"), is(roleStore.findById("3")));
        assertThat(new Role("4"), is(roleStore.findById("4")));
    }
    @Test
    public void replace() {
        assertTrue(roleStore.replace("1", new Role("6")));
        assertThat(new Role("6"), is(roleStore.findById("6")));
        assertTrue(roleStore.replace("2", new Role("7")));
        assertThat(new Role("7"), is(roleStore.findById("7")));
        assertTrue(roleStore.replace("3", new Role("8")));
        assertThat(new Role("8"), is(roleStore.findById("8")));
        assertTrue(roleStore.replace("4", new Role("9")));
        assertThat(new Role("9"), is(roleStore.findById("9")));
    }

    @Test(expected = NoSuchElementException.class)
    public void delete() {
        assertTrue(roleStore.delete("1"));
        assertTrue(roleStore.delete("2"));
        assertTrue(roleStore.delete("3"));
        assertTrue(roleStore.delete("4"));
        roleStore.findById("1");
    }

    @Test(expected = NoSuchElementException.class)
    public void findById() {
        roleStore.findById("22");
    }
}