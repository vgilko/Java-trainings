package Week4.Task2;

class Node<T> {
    private Node<T> previous, next;

    Node(T value) {
        this.value = value;
    }

    private T value;

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setValue (T newValue) {
        this.value = newValue;
    }

    public T getValue() {
        return value;
    }

}
