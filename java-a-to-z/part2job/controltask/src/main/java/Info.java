import java.util.ArrayList;
import java.util.List;

public class Info {
    private  Long numberNew;
    private  Long numberAdded;
    private Long numberDeleted;
    private List<User> previoues = new ArrayList<>();
    private List<User> current = new ArrayList<>();

    public Info(List<User> srcPrevioues, List<User> srcCurrent) {
        this.previoues = srcPrevioues;
        this.current = srcCurrent;
    }

    public Info getStore() {
        numberNew = current.stream().filter( element -> !previoues.contains(element)).count();
        numberAdded = current.stream().filter(element -> previoues
                .stream().filter(x -> x.equals(element) && !x.getName().equals(element.getName()))
                .count() != 0)
                .count();
        numberDeleted = previoues.stream().filter(element -> !current.contains(element)).count();
        return this;
    }

    public int getNumberNew() {
        return numberNew.intValue();
    }

    public int getNumberAdded() {
        return numberAdded.intValue();
    }

    public int getNumberDeleted() {
        return numberDeleted.intValue();
    }
}
