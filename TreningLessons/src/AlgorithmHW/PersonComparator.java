package AlgorithmHW;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    public int counter = 0;
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getWeight() - o2.getWeight() == 0 && o1.getHeight() - o2.getHeight() != 0) {
            counter += 2;
        }
        return o1.getHeight() - o2.getHeight();
    }
}
