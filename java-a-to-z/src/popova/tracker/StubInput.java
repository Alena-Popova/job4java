package popova.tracker;

public class StubInput implements Input {

    private final String[] value;
    private int position = 0;


    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    public String ask(String[] question) {
        return this.ask(question);
    }


    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int i : range) {
            if (i == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }

    }
}
