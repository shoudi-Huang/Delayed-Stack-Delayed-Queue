public class Node<E> {
    public E element;
    public Node<E> parent;
    public Node<E> child;

    public Node(E element) {
        this.element = element;
        this.parent = null;
        this.child = null;
    }

    public void SetParent(Node<E> nd) {
        this.parent = nd;
    }

    public void SetChild(Node<E> nd) {
        this.child = nd;
    }

    public boolean hasNext() {
        if(this.child != null) {
            return true;
        } else return false;
    }

    public Node<E> Next() {
        return this.child;
    }
}
