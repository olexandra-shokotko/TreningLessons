package HW9.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(10);
        myArrayList.add(3);
        myArrayList.add(56);
        myArrayList.add(12);
        myArrayList.add(4);

        System.out.println("Size: " + myArrayList.size());
        System.out.println(myArrayList.get(2));

        myArrayList.print();

        myArrayList.remove(3);
        myArrayList.print();
        System.out.println("Size: " + myArrayList.size());

        myArrayList.clear();
        System.out.println(myArrayList.size());
    }
}
