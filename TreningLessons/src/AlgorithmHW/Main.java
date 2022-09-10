package AlgorithmHW;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(189, 78, 20);
        Person p2 = new Person(160, 90, 21);
        Person p3 = new Person(173, 50, 19);
        Person p4 = new Person(110, 50, 10);
        Person p5 = new Person(110, 50, 45);
        Person p6 = new Person(190, 65, 65);
        Person p7 = new Person(185, 87, 34);
        Person p8 = new Person(156, 90, 12);
        Person p9 = new Person(178, 100, 34);
        Person p10 = new Person(145, 123, 28);
        Person p11 = new Person(187, 123, 45);
        Person p12 = new Person(170, 69, 13);
        Person p13 = new Person(160, 59, 54);
        Person p14 = new Person(181, 99, 65);
        Person p15 = new Person(183, 99, 87);

        Person[] people = new Person[] {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15};

        Comparator<Person> personAgeComparator = (o1, o2) -> o1.getAge() - o2.getAge();
        Comparator<Person> personHeightComparator = (o1, o2) -> o1.getHeight() - o2.getHeight();
        Comparator<Person> personWeightComparator = (o1, o2) -> o1.getWeight() - o2.getWeight();

        // Додаткове запитання. Можна забезпечити лінійну складність алгоритму по часу, якщо використовувати Radix sort
        // Radix sort має складність алгоритму O(nk), де k - кількість цифр в числі. В нашому випадку максимальне значення k може бути 3.
        // Адже ми сортуємо по віку, а вік може бути максимально трьохзначним числом.

        // 1 task
        System.out.println("Sort by age -----------------------------------------");
        Arrays.sort(people, personAgeComparator);
        for (Person p : people) {
            System.out.println(p);
        }

        // 2 task
        System.out.println("Sort by height -----------------------------------------");
        Arrays.sort(people, personHeightComparator);
        for (Person p : people) {
            System.out.println(p);
        }
        System.out.println("Sort by weight-----------------------------------------");
        Arrays.sort(people, personWeightComparator);
        for (Person p : people) {
            System.out.println(p);
        }

        //3 task
        System.out.println("-----------------------------------------");

        Arrays.sort(people, personWeightComparator);
        System.out.println("Quantity of people with same weight and different height: " + findPeopleSameWeightDiffHeight(people));
    }

    // Best time complexity: O(n)
    // Worst time complexity: O(n*n)
    public static int findPeopleSameWeightDiffHeight(Person[] people) {
        int resultCounter = 0;
        int currentWeight = people[0].getWeight();
        int sameWeightCounter = 0;
        List<Integer> heights = new ArrayList<>();

        for (int i = 0; i < people.length; i++) { // n
            if (people[i].getWeight() == currentWeight) {
                if (!heights.contains(people[i].getHeight())) {
                    heights.add(people[i].getHeight());
                }
                sameWeightCounter++;
            } else {
                currentWeight = people[i].getWeight();
                if (sameWeightCounter >= 2) {
                    resultCounter += heights.size();
                }
                sameWeightCounter = 1;
                heights.clear();
                heights.add(people[i].getHeight());
            }
        }
        if (sameWeightCounter >= 2) {
            resultCounter += heights.size();
        }

        return resultCounter;
    }
}
