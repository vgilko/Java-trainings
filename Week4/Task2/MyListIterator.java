package Week4.Task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListIterator<T> implements Iterator<T> {
    Node<T> current;

    MyListIterator (MyList<T> list) {
        current = list.getBegin();
    }


    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (current == null)
            throw new NoSuchElementException();

        T data = current.getValue();
        current = current.getNext();

        return data;
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
