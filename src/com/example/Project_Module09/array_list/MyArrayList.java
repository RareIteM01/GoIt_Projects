package com.example.Project_Module09.array_list;

import java.util.Arrays;

public class MyArrayList<T> {
    public static final int DEFAULT_SIZE = 10;
    private T[] array;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_SIZE];
    }

    public void add(T value) {
        if (size == array.length) {
            increaseSize();
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void increaseSize() {
        int newSize = array.length * 3 / 2;
        T[] oldArray = array;
        array = (T[]) new Object[newSize];
        System.arraycopy(oldArray, 0, array, 0, size);
    }
}
