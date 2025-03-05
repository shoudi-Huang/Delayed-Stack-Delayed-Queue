import static org.junit.Assert.*;
import org.junit.Test;

public class MyQueueTest {

    @Test
    public void NodeTest() {
        Node<String> ns = new Node<String>("String1");
        Node<String> ns1 = new Node<String>("String2");
        assertEquals("String1", ns.element);
        assertEquals("String2", ns1.element);
        assertNull(ns.parent);
        assertNull(ns.child);
        assertNull(ns.Next());
        assertFalse(ns.hasNext());
        assertNull(ns1.parent);
        assertNull(ns1.child);
        assertNull(ns1.Next());
        assertFalse(ns1.hasNext());

        ns.SetChild(ns1);
        ns1.SetParent(ns);
        assertNull(ns.parent);
        assertSame(ns1, ns.child);
        assertSame(ns1, ns.Next());
        assertTrue(ns.hasNext());
        assertSame(ns, ns1.parent);
        assertNull(ns1.child);
        assertNull(ns1.Next());
        assertFalse(ns1.hasNext());
        
        Node<Integer> nI = new Node<Integer>(1);
        Node<Integer> nI1 = new Node<Integer>(2);
        assert 1 == nI.element;
        assert 2 == nI1.element;
        
        Node<Double> nd = new Node<Double>(0.245);
        Node<Object> nnd = new Node<Object>(nd);
        assertSame(nd, nnd.element);
        assert 0.245 == nd.element;

    }

    @Test
    public void ConstructerTest() {
        MyQueue q = new MyQueue(4);
        assertNull(q.getHead());
        assertNull(q.getTail());
        assertEquals(0, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertFalse(q.isPoping());
        assertEquals(0, q.size());

        MyQueue q1 = new MyQueue(0);
        assertNull(q1.getHead());
        assertNull(q1.getTail());
        assertEquals(0, q1.getCurrentDelay());
        assertEquals(1, q1.getDelayCondition());
        assertEquals(-1, q1.getUpdate_Delay_Condition());
        assertFalse(q1.isPoping());
        assertEquals(0, q1.size());

        MyQueue q2 = new MyQueue(-10);
        assertNull(q2.getHead());
        assertNull(q2.getTail());
        assertEquals(0, q2.getCurrentDelay());
        assertEquals(1, q2.getDelayCondition());
        assertEquals(-1, q2.getUpdate_Delay_Condition());
        assertFalse(q2.isPoping());
        assertEquals(0, q2.size());

        MyQueue q3 = new MyQueue(297);
        assertNull(q3.getHead());
        assertNull(q3.getTail());
        assertEquals(0, q3.getCurrentDelay());
        assertEquals(297, q3.getDelayCondition());
        assertEquals(-1, q3.getUpdate_Delay_Condition());
        assertFalse(q3.isPoping());
        assertEquals(0, q3.size());
    }

    @Test
    public void Enqueue_DequeueTest() {
        MyQueue<String> q = new MyQueue<String>(4);
        assertNull(q.getHead());
        assertNull(q.getTail());
        q.enqueue("first element");
        assertEquals(1, q.size());
        assertEquals("first element", q.getHead().element);
        assertEquals("first element", q.getTail().element);
        assertEquals(1, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertFalse(q.isPoping());
        assertNull(q.dequeue());
        assertFalse(q.isPoping());

        q.enqueue("Second");
        assertEquals(2, q.size());
        assertEquals("Second", q.getHead().element);
        assertEquals("first element", q.getTail().element);
        assertEquals(2, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertFalse(q.isPoping());
        assertNull(q.dequeue());
        assertFalse(q.isPoping());

        q.enqueue("3");
        assertEquals(3, q.size());
        assertEquals("3", q.getHead().element);
        assertEquals("first element", q.getTail().element);
        assertEquals(3, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertFalse(q.isPoping());
        assertNull(q.dequeue());
        assertFalse(q.isPoping());

        q.enqueue("4");
        assertEquals(4, q.size());
        assertEquals("4", q.getHead().element);
        assertEquals("first element", q.getTail().element);
        assertEquals(4, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertFalse(q.isPoping());

        assertEquals("first element", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(4, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(3, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertEquals("4", q.getHead().element);
        assertEquals("Second", q.getTail().element);

        assertEquals("Second", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(4, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(2, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertEquals("4", q.getHead().element);
        assertEquals("3", q.getTail().element);

        q.enqueue("4");
        assertEquals(3, q.size());
        assertEquals("4", q.getHead().element);
        assertEquals("3", q.getTail().element);
        assertEquals(1, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertFalse(q.isPoping());
        
        q.enqueue("5");
        assertEquals(4, q.size());
        assertEquals("5", q.getHead().element);
        assertEquals("3", q.getTail().element);
        assertEquals(2, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertNull(q.dequeue());
        assertEquals(4, q.size());
        assertFalse(q.isPoping());

        q.enqueue("6");
        assertEquals(5, q.size());
        assertEquals("6", q.getHead().element);
        assertEquals("3", q.getTail().element);
        assertEquals(3, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertNull(q.dequeue());
        assertFalse(q.isPoping());

        q.enqueue("7");
        assertEquals(6, q.size());
        assertEquals("7", q.getHead().element);
        assertEquals("3", q.getTail().element);
        assertEquals(4, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertFalse(q.isPoping());

        q.enqueue("8");
        assertEquals(7, q.size());
        assertEquals("8", q.getHead().element);
        assertEquals("3", q.getTail().element);
        assertEquals(5, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertFalse(q.isPoping());

        assertEquals("3", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(5, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(6, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertEquals("8", q.getHead().element);
        assertEquals("4", q.getTail().element);

        assertEquals("4", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(5, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(5, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertEquals("8", q.getHead().element);
        assertEquals("4", q.getTail().element);

        assertEquals("4", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(5, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(4, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertEquals("8", q.getHead().element);
        assertEquals("5", q.getTail().element);

        assertEquals("5", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(5, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(3, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertEquals("8", q.getHead().element);
        assertEquals("6", q.getTail().element);

        assertEquals("6", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(5, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(2, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertEquals("8", q.getHead().element);
        assertEquals("7", q.getTail().element);

        assertEquals("7", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(5, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(1, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertEquals("8", q.getHead().element);
        assertEquals("8", q.getTail().element);

        assertEquals("8", q.dequeue());
        assertTrue(q.isPoping());
        assertEquals(5, q.getCurrentDelay());
        assertEquals(4, q.getDelayCondition());
        assertEquals(0, q.size());
        assertEquals(-1, q.getUpdate_Delay_Condition());
        assertNull(q.getHead());
        assertNull(q.getTail());

        boolean valid_exception = false;
        try{
            q.dequeue();
        } catch(IllegalStateException e) {
            valid_exception = true;
        }
        assertTrue(valid_exception);
        assertEquals(0, q.size());
    }

    @Test
    public void peekTest() {
        MyQueue<Integer> q = new MyQueue<Integer>(0);
        assertEquals(0, q.size());
        boolean valid_exception = false;
        try{
            q.peek();
        } catch(IllegalStateException e) {
            valid_exception = true;
        }
        assertTrue(valid_exception);

        q.enqueue(1);
        assertEquals((int) 1, (int) q.peek());
        assertEquals((int) 1, (int) q.peek());
        assertEquals(1, q.size());
        assertFalse(q.isPoping());
        q.enqueue(2);
        assertEquals((int) 1, (int) q.peek());
        assertEquals(2, q.size());
        assertFalse(q.isPoping());
        q.dequeue();
        assertEquals((int) 2, (int) q.peek());
        assertEquals(1, q.size());
        assertTrue(q.isPoping());
        q.dequeue();
        assertEquals(0, q.size());

        valid_exception = false;
        try{
            q.peek();
        } catch(IllegalStateException e) {
            valid_exception = true;
        }
        assertTrue(valid_exception);
    }

    @Test
    public void getDelayTest() {
        DelayedQueue<Integer> q = new MyQueue<Integer>(0);
        DelayedQueue<Integer> q1 = new MyQueue<Integer>(-4);
        DelayedQueue<Integer> q2 = new MyQueue<Integer>(1);
        assertEquals(0, q.getDelay());
        assertEquals(0, q1.getDelay());
        assertEquals(0, q2.getDelay());

        DelayedQueue<Integer> q3 = new MyQueue<Integer>(4);
        assertEquals(4, q3.getDelay());
        q3.enqueue(10);
        assertEquals(3, q3.getDelay());
        q3.enqueue(9);
        assertEquals(2, q3.getDelay());
        q3.enqueue(8);
        assertEquals(1, q3.getDelay());
        q3.enqueue(7);
        assertEquals(0, q3.getDelay());
        q3.enqueue(6);
        assertEquals(0, q3.getDelay());
        q3.dequeue();
        assertEquals(0, q3.getDelay());
        q3.dequeue();
        assertEquals(0, q3.getDelay());
        q3.enqueue(1);
        assertEquals(3, q3.getDelay());
        q3.dequeue();
        assertEquals(3, q3.getDelay());
    }

    @Test
    public void MaximumDelayTest() {
        MyQueue<Double> q = new MyQueue<Double>(2);
        assertEquals(2, q.getMaximumDelay());
        q.enqueue(0.1);
        assertEquals(1, q.getCurrentDelay());
        assertEquals(2, q.getDelayCondition());
        assertEquals(2, q.getMaximumDelay());
        q.enqueue(0.2);
        assertEquals(0, q.getDelay());
        assertEquals(2, q.getMaximumDelay());
        q.setMaximumDelay(3);
        assertEquals(3, q.getMaximumDelay());
        assertEquals(2, q.getDelayCondition());
        q.enqueue(0.3);
        assertEquals(2, q.getDelayCondition());
        q.dequeue();
        q.dequeue();
        assertEquals(2, q.getDelayCondition());
        q.enqueue(0.4);
        assertEquals(3, q.getMaximumDelay());
        assertEquals(3, q.getDelayCondition());
        assertEquals(2, q.getDelay());
        
        MyQueue<String> q2 = new MyQueue<String>(4);
        assertEquals(4, q2.getMaximumDelay());
        q2.enqueue("first");
        q2.setMaximumDelay(3);
        q2.setMaximumDelay(4);
        q2.setMaximumDelay(2);
        assertEquals(3, q2.getDelay());
        assertEquals(2, q2.getMaximumDelay());
        assertEquals(4, q2.getDelayCondition());
        q2.enqueue("second");
        q2.enqueue("3");
        q2.enqueue("4");
        assertEquals(0, q2.getDelay());
        q2.dequeue();
        assertEquals(4,q2.getDelayCondition());
        q2.enqueue("5");
        assertEquals(2, q2.getDelayCondition());
        assertEquals(1, q2.getDelay());
        q2.enqueue("6");
        q2.dequeue();
        assertEquals(0, q2.getDelay());

        MyQueue<String> q3 = new MyQueue<String>(1);
        assertEquals(0, q3.getDelay());
    }

    @Test
    public void clearTest() {
        MyQueue<Integer> q = new MyQueue<Integer>(4);
        assertEquals(0, q.size());
        assertFalse(q.clear());
        assertFalse(q.isPoping());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        assertEquals(0, q.getDelay());
        assertTrue(q.clear());
        assertNull(q.getHead());
        assertNull(q.getTail());
        assertEquals(0, q.size());
        assertTrue(q.isPoping());
        assertTrue(q.clear());
    }
    
    @Test
    public void containTest() {
        DelayedQueue<String> q = new MyQueue<String>(1);

        assertFalse(q.contains("haha"));
        q.enqueue("haha");
        assertTrue(q.contains("haha"));
        q.dequeue();

        q.enqueue(null);
        assertTrue(q.contains(null));
        q.dequeue();

        q.enqueue("sh");
        q.enqueue("Psf");
        assertFalse(q.contains(null));
        q.enqueue(null);
        q.enqueue("SHE");
        assertTrue(q.contains("sh"));
        assertTrue(q.contains(null));
        assertFalse(q.contains("not exist"));

    }
}
