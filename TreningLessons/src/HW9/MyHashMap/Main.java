package HW9.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(0, 10);
        myHashMap.put(1, 11);
        myHashMap.put(2, 12);
        myHashMap.put(3, 13);
        myHashMap.put(4, 14);
        myHashMap.put(5, 15);

        System.out.println("---------");
        System.out.println(myHashMap);
        System.out.println("Size: " + myHashMap.size());

        System.out.println("HashMap after removing element with key 3---------");
        myHashMap.remove(3);
        System.out.println(myHashMap);
        System.out.println("Size: " + myHashMap.size());

        System.out.println("Getting element by key 4---------");
        System.out.println(myHashMap.get(4));

        System.out.println("HashMap after clear---------");
        myHashMap.clear();
        System.out.println(myHashMap);
        System.out.println("Size: " + myHashMap.size());
    }
}
