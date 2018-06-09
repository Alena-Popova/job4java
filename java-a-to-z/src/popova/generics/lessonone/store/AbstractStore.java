package popova.generics.lessonone.store;

import popova.generics.SimpleArray;
import popova.generics.lessonone.Base;
import popova.generics.lessonone.Store;

import java.util.Iterator;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    public int findIndexInStore(SimpleArray<T> array, String id) {
        int result = -1;
        Iterator<T> iterator = array.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }
}
