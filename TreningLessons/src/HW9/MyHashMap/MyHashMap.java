package HW9.MyHashMap;

public class MyHashMap {
    private int size;
    private Node tail;

    public MyHashMap() {
        size = 0;
    }

    // if in hashmap already exists node with given key it will be replace with new node
    public void put(Object key, Object value) {
        Node newNode = new Node(key, value, null);
        if (tail == null) {
            tail = newNode;
        } else {
            if (ifKeyExist(newNode)) {
                remove(key);
            }
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void remove(Object key) {
        Node prevCurrentNode = tail;
        Node currentNode = tail.getNext();
        if (tail.getKey().equals(key)) {
            tail = tail.getNext();
        }
        for (int i = 0; i < (size); i++) {
            if (currentNode.getKey().equals(key)) {
                prevCurrentNode.setNext(currentNode.getNext());
                currentNode = null;
                size--;
                break;
            } else if (currentNode.getNext() != null) {
                prevCurrentNode = prevCurrentNode.getNext();
                currentNode = currentNode.getNext();
            } else {
                break;
            }
        }
    }

    public void clear() {
        tail.setNext(null);
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        Node node = tail;
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private boolean ifKeyExist(Node node) {
        if (tail.getKey().equals(node.getKey())) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (tail.getNext() != null) {
                if (tail.getNext().getKey().equals(node.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void print() {
        Node node = tail;
        while (node != null) {
            System.out.println(node);
            node = node.getNext();
        }
    }
}
