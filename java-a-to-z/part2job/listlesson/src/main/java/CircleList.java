public class CircleList<E> {

    private Node<E> first;

    public static class Node<E> {
        E date = null;
        Node<E> next = null;
        Node<E> previous = null;

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

        Node step = first;
        Node stepNext = first.next;
        LabelOne: while (stepNext != null) {
            Node circle = first;
            while (circle != step) {
                System.out.println(circle + "-no-" + stepNext);
                if (circle == stepNext) {
                    System.out.println(circle + "--" + stepNext);
                    result = true;
                    break LabelOne;
                }
                circle = circle.next;
            }
            step = stepNext;
            stepNext = stepNext.next;
        }
        return result;
    }
}
