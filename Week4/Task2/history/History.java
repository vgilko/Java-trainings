package Week4.Task2.history;

import java.util.Stack;

public class History <T>{
    Stack <Memento<T>> history = new Stack<>();

    public void push (Memento<T> state) {
        history.push(state);
    }

    public boolean undo () {
        if (history.empty()) {
            return false;
        }

        history.pop().restore();

        return true;
    }
}
