import baseclasses.SimpleList;

public class SimpleSet<E> extends SimpleList<E> {

    private Object[] container = new Object[10];
    int index = 0;
    int modCount = 0;

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

        container = super.getContainer();
        index = super.getIndex();
        modCount = super.getModCount();

        return result;
    }
}
