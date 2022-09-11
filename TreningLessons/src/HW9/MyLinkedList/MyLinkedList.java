package HW9.MyLinkedList;

public class MyLinkedList {
    private class Node {
        Object value;
        Node next;
        Node prev;
        public Node(Object value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList(){
        size = 0;
    }

    public void add(Object value){
        Node newNode = new Node(value, null, tail);
        if(head == null) {
            head = newNode;
        }
        if(tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public void remove(int index){
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else {
            Node node = head;
            for(int i = 0; i < index - 1; i++){
                node = node.next;
            }
            node.next = node.next.next;
            node.next.next.prev = node;
            size--;
        }
    }

    public void clear() {
        head.next = null;
        tail.prev = null;
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else {
            Node node = head;
            for(int i = 0; i < index; i++){
                node = node.next;
            }
            return node.value;
        }
    }

    public void print(){
        Node node = head;
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }
}
