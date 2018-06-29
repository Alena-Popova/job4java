import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root = null;
    private Node<E> last = null;
    @Override
    public boolean add(E parent, E child) {
        boolean request = false;
        if (root == null) {
            root = new Node<E>(parent);
            root.add(new Node<>(child));
            request = true;
        } else {
            Node<E> result = findBy(parent).get();
            if(result == null) {
                Node<E> step = new Node<E>(parent);
                step.add(new Node<>(child));
                root.add(step);
                request = true;
            } else  {
                Node<E> descendant = new Node<>(child);
                if (!result.leaves().contains(descendant)) {
                    result.add(descendant);
                    request = true;
                }
            }

        }
        return request;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {

        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


    @Override
    public Iterator<E> iterator() {
        //горизонтальный (в ширину)
        Iterator<E> iterator = new Iterator<E>() {
            private List<Node<E>> target = new ArrayList<>();
            private int count = 0;
            private int finish = 0;

            {
             target.add(root);
            }

            public boolean hasNext() {
                return  count < finish;
            }

            public E next() {
                if (finish == 0)
                    throw new NullPointerException();
                if (count == finish) {
                    count = 0;
                    target = callMove(target);
                }
                return target.get(count++).getValue();
            }

            private List<Node<E>> callMove(List<Node<E>> list) {
                List<Node<E>> move = new ArrayList<>();
                for (Node<E> step : target) {
                    if (step.leaves().size() != 0) {
                        move.addAll(step.leaves());
                    }
                }
                finish = move.size();
                return move;
            }

            public void remove() {

            }


        };
        return iterator;
    }

}
