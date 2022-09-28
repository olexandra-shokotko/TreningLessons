package HW9.MyHashMap;

import java.util.Arrays;

public class MyHashMap {
    private int size;
    private Node[] table;
    static final int capacity = 16;

    public MyHashMap() {
        size = 0;
        table = new Node[capacity];
    }

    public void put(Object key, Object value) {
        int index = index(key);
        Node newNode = new Node(key, value, null);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node prevNode = null;
            Node curNode = table[index];

            while (curNode != null) {
                if (curNode.getKey().equals(key)) {
                    curNode.setValue(value);
                    break;
                }
                prevNode = curNode;
                curNode = curNode.getNext();
            }
            if (prevNode != null)
                prevNode.setNext(newNode);
        }
        size++;
    }

    public void remove(Object key) {
        int index = index(key);
        Node prev = null;
        Node node = table[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                if (prev == null) {
                    node = node.getNext();
                    table[index] = node;
                } else {
                    prev.setNext(node.getNext());
                }
                size--;
                return;
            }
            prev = node;
            node = node.getNext();
        }
    }

    public Object get(Object key) {
        Object value = null;
        int index = index(key);
        Node node = table[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                value = node.getValue();
                break;
            }
            node = node.getNext();
        }
        return value;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private int index(Object key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Node curNode = table[i];
                while (curNode != null) {
                    stringBuilder.append(curNode).append("\n");
                    curNode = curNode.getNext();
                }
            }
        }
        return stringBuilder.toString();
    }
}
