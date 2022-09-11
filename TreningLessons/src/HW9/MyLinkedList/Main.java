package HW9.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(10);
        myLinkedList.add(11);
        myLinkedList.add(12);
        myLinkedList.add(13);
        myLinkedList.add(14);
        myLinkedList.add(15);

        System.out.println("List-----------------------");
        myLinkedList.print();
        System.out.println("Size: " + myLinkedList.size());

        System.out.println("\nList after removing element by index 3-----------------------");
        myLinkedList.remove(3);
        myLinkedList.print();
        System.out.println("Size: " + myLinkedList.size());

        System.out.println("\nElement by index 2-----------------------");
        System.out.println(myLinkedList.get(2));

        System.out.println("\nList after clear -----------------------");
        myLinkedList.clear();
        System.out.println("Size: " + myLinkedList.size());

    }
}
