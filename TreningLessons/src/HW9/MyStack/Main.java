package HW9.MyStack;

public class Main {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(10); //0
        myStack.push(11); //1
        myStack.push(12); //2
        myStack.push(13); //3
        myStack.push(14); //4
        myStack.push(15); //5

        System.out.println("---------");
        System.out.println(myStack);
        System.out.println("Size: " + myStack.size());

        System.out.println("Stack after removing second element---------");
        myStack.remove(2);
        System.out.println(myStack);
        System.out.println("Size: " + myStack.size());

        System.out.println("First element: " + myStack.peek());

        System.out.println("First element amd removing it---------");
        System.out.println("First element: " + myStack.pop());
        System.out.println(myStack);
        System.out.println("Size: " + myStack.size());

        System.out.println("Stack after clear---------");
        myStack.clear();
        System.out.println(myStack);
        System.out.println("Size: " + myStack.size());
    }
}
