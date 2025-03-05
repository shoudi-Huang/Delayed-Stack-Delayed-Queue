public class MyQueue<E> implements DelayedQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int current_delay;
    private int delay_condition;
    private int update_delay_condition;
    private boolean poping;
    private boolean updating;

    public MyQueue(int delay_condition) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.poping = false;
        this.current_delay = 0;
        this.update_delay_condition = -1;
        this.delay_condition = delay_condition;
        if(this.delay_condition <= 0)
            this.delay_condition = 1;
        this.updating = false;
    }

    public Node<E> getHead() {return head;}
    
    public Node<E> getTail() {return tail;}

    public int getCurrentDelay() {return current_delay;}
    
    public int getDelayCondition() {return delay_condition;}

    public int getUpdate_Delay_Condition() {return update_delay_condition;}
    
    public boolean isPoping() {return poping;}

    public int size(){
        return this.size;
    }

    public void enqueue(E element) {
        Node<E> new_node = new Node<E>(element);
        if(size == 0) {
            this.head = new_node;
            this.tail = new_node;
        }
        else {
            this.head.SetParent(new_node);
            new_node.SetChild(this.head);
            this.head = new_node;
        }
        size++;
        if(poping == true) {
            current_delay = 1;
            poping = false;
            if(updating) {
                if(update_delay_condition <= 0) {
                    delay_condition = 1;
                } else {
                    delay_condition = update_delay_condition;
                }
            }
        }else current_delay++;
    }

    public E dequeue() throws IllegalStateException {
        if(size == 0) {
            throw new IllegalStateException();
        }else if(current_delay < delay_condition) {
            return null;
        }

        
        E re_element = this.tail.element;
        if(size == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            tail = tail.parent;
        }
        size--;
        poping = true;
        return re_element;
    }

    public E peek() throws IllegalStateException {
        if(size == 0)
            throw new IllegalStateException();

        E re_element = this.tail.element;
        return re_element;
    }

    public int getDelay() {
        if(delay_condition == 1) {
            return 0;
        }
        if(current_delay < delay_condition) {
            return delay_condition - current_delay;
        }
        else return 0;
    }

    public void setMaximumDelay(int d) {
        this.update_delay_condition = d;
        this.updating = true;
    }

    public int getMaximumDelay() {
        if(updating) {
            return this.update_delay_condition;
        } else {
            if(delay_condition == 1) {
                return 0;
            } else return delay_condition;
        }
    }

    public boolean clear() {
        if(current_delay < delay_condition) {
            return false;
        }
        this.poping = true;
        this.head = null;
        this.tail = null;
        this.size = 0;
        return true;
    }

    public boolean contains(E elem) {
        if(size == 0)
            return false;

        Node<E> current_node = this.head;
        if(current_node.element == null || elem == null) {
            if(elem == null && current_node.element == null)
                return true;
        } else if(current_node.element.equals(elem)) {
            return true;
        }
        while(current_node.hasNext()) {
            current_node = current_node.Next();
            if(current_node.element == null || elem == null) {
                if(elem == null && current_node.element == null)
                    return true;
            } else if(current_node.element.equals(elem)) {
                return true;
            }
        }
        
        return false;
    }

    
}
