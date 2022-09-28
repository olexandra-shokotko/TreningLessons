package HW9.MyStack;

import java.util.Objects;

public class MyStack {
    private int size;
    private Node head;

    public MyStack() {
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value, null);
        if (head != null) {
            newNode.prev = head;
        }
        head = newNode;
        size++;
    }

    public void remove(int index) {
        try {
            Objects.checkIndex(index, size);
            if (index == size - 1) {
                head = head.prev;
            } else {
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
            }
            size--;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid index");
        }
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
        Node prevNode = head;
        Node curNode = prevNode.prev;
        while (curNode.prev != null) {
            prevNode = prevNode.prev;
            curNode = curNode.prev;
        }
        prevNode.prev = null;
        size--;
        return curNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.value).append("\n");
            node = node.prev;
        }
        return stringBuilder.toString();
    }

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
}
