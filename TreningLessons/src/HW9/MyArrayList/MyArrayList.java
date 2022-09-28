package HW9.MyArrayList;

import HW9.MyLinkedList.MyLinkedList;

import java.util.Arrays;
import java.util.Objects;

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
        try {
            Objects.checkIndex(index, size);
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid index");
        }
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
        try {
            Objects.checkIndex(index, size);
            return elements[index];
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid index");
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]).append(" ");
        }
        return stringBuilder.toString();
    }
}
