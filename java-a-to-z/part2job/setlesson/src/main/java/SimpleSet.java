import baseclasses.SimpleList;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SimpleSet<E> extends SimpleList<E>{

    private Object[] container = new Object[10];


    private boolean isRepeatInMySet(E value) {
        boolean result = false;
        for(Object step : container) {
            if (step != null && ((E)step).equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean add(E value) {
        boolean result = false;
        if (!isRepeatInMySet(value))
            result = super.add(value);
        return result;
    }

}
