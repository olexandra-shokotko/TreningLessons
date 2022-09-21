package AlgorithmHW;

import java.util.Comparator;

public class QuickSort {

    static void sort(Person[] arr, Comparator<Person> personComparator) {
        sort(arr, 0, arr.length - 1, personComparator);
    }

    static void sort(Person[] arr, int low, int high, Comparator<Person> personComparator) {
        if (low < high) {
            int p = partition(arr, low, high, personComparator);

            sort(arr, low, p - 1, personComparator);
            sort(arr, p + 1, high, personComparator);
        }
    }

    private static void swap(Person[] arr, int i, int j) {
        Person temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(Person[] arr, int low, int high, Comparator<Person> personComparator) {
        Person pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (personComparator.compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
}
