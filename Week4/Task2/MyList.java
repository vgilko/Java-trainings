package Week4.Task2;

import Week4.Task2.history.History;
import Week4.Task2.history.Memento;

import java.util.Iterator;

public class MyList<T> implements Iterable<T>{
    private Node<T> begin;
    private Node<T> end;

    History<T> history = new History<>();

    public Node<T> getBegin() {
        return begin;
    }

    public Node<T> getEnd() {
        return end;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(this);
    }

    public void print () {
        Node<T> next = begin;

        while (next != null) {
            System.out.println(next.getValue());

            next = next.getNext();
        }
    }

    public void pushBack (T value) {
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

    public void popBack () {
        if (begin == null) {
            throw new IndexOutOfBoundsException("Попытка очистить пустой список");
        }

        history.push(new Memento<T>(this));

        if (begin == end) {
            begin = null;
        }

        end.getPrevious().setNext(null);
        end = end.getPrevious();
    }

    public void undo () {
        history.undo();
    }

    public T backup () {
        return end.getValue();
    }

    public void restore (T value) {
        this.pushBack(value);
    }
}


