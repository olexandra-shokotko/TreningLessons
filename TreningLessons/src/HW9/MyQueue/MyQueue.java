package HW9.MyQueue;

public class MyQueue {
    private class Node {
        Object value;
        Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private Node tail;
    private int size;

    public MyQueue() {
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value, null);
        if (tail != null) {
            newNode.next = tail;
        }
        tail = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == size - 1) {
            tail = tail.next;
        } else {
            Node currentNode = tail;
            Node prevCurrentNode = currentNode;
            for (int i = 0; i < (size - index - 2); i++) {
                prevCurrentNode = prevCurrentNode.next;
            }
            for (int i = 0; i < (size - index - 1); i++) {
                currentNode = currentNode.next;
            }
            prevCurrentNode.next = currentNode.next;
            currentNode.next = null;
            currentNode = null;
        }
        size--;
    }

    public void clear() {
        tail.next = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        Node currentNode = tail;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public Object poll() {
        Node prevNode = tail;
        Node curNode = prevNode.next;
        while (curNode.next != null) {
            prevNode = prevNode.next;
            curNode = curNode.next;
        }
        prevNode.next = null;
        size--;
        return curNode;
    }

    public void print() {
        Node node = tail;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
