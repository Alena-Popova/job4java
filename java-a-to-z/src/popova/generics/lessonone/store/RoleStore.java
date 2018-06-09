package popova.generics.lessonone.store;

import popova.generics.SimpleArray;
import popova.generics.lessonone.Base;
import popova.generics.lessonone.Role;
import popova.generics.lessonone.Store;

import java.util.NoSuchElementException;

public class RoleStore<T extends Base>  extends AbstractStore<T> {

    private SimpleArray<T> roleArray;

    public RoleStore(int size) {
        roleArray = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        roleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexInStore(roleArray, id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        roleArray.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexInStore(roleArray, id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        roleArray.delete(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = findIndexInStore(roleArray, id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return roleArray.get(index);
    }
}
