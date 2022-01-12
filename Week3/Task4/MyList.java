package Week3.Task4;

import java.util.Iterator;

public class MyList<T> implements Iterable<T> {

    private Node<T> begin;
    private Node<T> end;

    public Node<T> getBegin() {
        return begin;
    }

    public Node<T> getEnd() {
        return end;
    }

    public void print () {
        Node<T> next = begin;

        while (next != null) {
            System.out.println(next.getValue());

            next = next.getNext();
        }
    }

    public void push_back (T value) {
        if (begin == null) {
            begin = new Node<>(value);
            end = begin;
            end.setPrevious(begin);
        } else {
            Node<T> new_end = new Node<>(value);
            new_end.setPrevious(end);
            end.setNext(new_end);
            end = new_end;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(this);
    }
}


