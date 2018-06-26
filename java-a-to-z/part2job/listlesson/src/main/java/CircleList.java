public class CircleList<E> {

    private Node<E> first;

    public static class Node<E> {
        E date = null;
        Node<E> next = null;
        Node(E date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "date=" + date.toString() +
                    '}';
        }
    }

    boolean hasCycle(Node first) {
        boolean result = false;
        if (first != null) {
            Node step = first;
            Node stepNext = first;
            while (step != null && stepNext != null && stepNext.next != null) {
                step = step.next;
                System.out.println(step.date);
                stepNext = stepNext.next.next;
                System.out.println(stepNext.date);
                if (step == stepNext)
                    return true;
            }
            return false;
        }
        return result;
    }
}
