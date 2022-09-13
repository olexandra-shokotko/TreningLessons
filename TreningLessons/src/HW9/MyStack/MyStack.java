package HW9.MyStack;

public class MyStack {
    private class Node {
        Object value;
        Node prev;

        public Node(Object value, Node prev) {
            this.value = value;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private int size;
    private Node head;

    public MyStack() {
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.prev = head;
            head = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node currentNode = head;
        Node prevCurrentNode = currentNode;
        for (int i = 0; i < (size - index - 2); i++) {
            prevCurrentNode = prevCurrentNode.prev;
        }
        for (int i = 0; i < (size - index - 1); i++) {
            currentNode = currentNode.prev;
        }
        prevCurrentNode.prev = currentNode.prev;
        currentNode.prev = null;
        currentNode = null;
        size--;
    }

    public void clear() {
        head.prev = null;
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        Node currentNode = head;
        while (currentNode.prev != null) {
            currentNode = currentNode.prev;
        }
        return currentNode;
    }

    public Object pop() {
        Node currentNode = head;
        Node prevCurrentNode = currentNode;
        for (int i = 0; i < (size - 2); i++) {
            prevCurrentNode = prevCurrentNode.prev;
        }
        for (int i = 0; i < (size - 1); i++) {
            currentNode = currentNode.prev;
        }
        prevCurrentNode.prev = null;
        size--;
        return currentNode;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.prev;
        }
    }

}
