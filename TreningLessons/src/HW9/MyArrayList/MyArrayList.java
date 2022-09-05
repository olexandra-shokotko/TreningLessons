package HW9.MyArrayList;

import java.util.Arrays;

public class MyArrayList {
    private static final int INITIAL_SIZE = 10;
    private int size;
    private Object[] elements;

    public MyArrayList(int initialSize) {
        elements = new Object[initialSize];
    }
    public MyArrayList() {
        elements = new Object[INITIAL_SIZE];
    }

    public void add(Object value) {
        if (size == elements.length) {
            increaseSize();
        }
        elements[size++] = value;
    }

    private void increaseSize() {
        int newIncreasedSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newIncreasedSize);
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println("\n");
    }
}
