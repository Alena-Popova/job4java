package popova.generics.lessonone.store;

import popova.generics.SimpleArray;
import popova.generics.lessonone.Base;
import popova.generics.lessonone.Store;
import popova.generics.lessonone.User;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UserStore<T extends Base> extends AbstractStore<T> {

    private SimpleArray<T> userArray;

    public UserStore(int size) {
        userArray = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        userArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexInStore(userArray, id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        userArray.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexInStore(userArray, id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        userArray.delete(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = findIndexInStore(userArray, id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return userArray.get(index);
    }

}
