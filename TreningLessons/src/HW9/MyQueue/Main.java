package HW9.MyQueue;

public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.add(10);
        myQueue.add(11);
        myQueue.add(12);
        myQueue.add(13);
        myQueue.add(14);
        myQueue.add(15);
        myQueue.add(16);
        myQueue.add(17);
        myQueue.add(18);
        myQueue.add(19);
        myQueue.add(20);

        myQueue.print();
        System.out.println("Size: " + myQueue.size());

        System.out.println("First element: " + myQueue.peek());

        System.out.println("Queue after removing 2 index element------------");
        myQueue.remove(9);
        myQueue.print();
        System.out.println("Size: " + myQueue.size());

        System.out.println("First element and removing it------------");
        System.out.println("First element: " + myQueue.poll());
        myQueue.print();
        System.out.println("Size: " + myQueue.size());

        System.out.println("Queue after clear------------");
        myQueue.clear();
        myQueue.print();
        System.out.println("Size: " + myQueue.size());
    }
}
