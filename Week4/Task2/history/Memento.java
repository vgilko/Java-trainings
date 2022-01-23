package Week4.Task2.history;

import Week4.Task2.MyList;

public class Memento <T> {
    private final MyList<T> list;
    private final T state;


    public Memento(MyList<T> list) {
        this.list = list;
        this.state = list.backup();
    }

    public T getState () {
        return state;
    }

    public void restore () {
        list.restore(state);
    }
}
