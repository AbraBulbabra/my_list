package org.example.my.list;

public class MyArrayList<T> {
    // Default size capacity my ArrayList.
    private static final int DEFAULT_CAPACITY = 10;

    //Default capacity for empty list.
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENTDATA = {};

    // The array buffer into which the elements of the ArrayList.
    private Object[] matrixElements;

    private int size;

    public MyArrayList() {
        this.matrixElements = new Object[DEFAULT_CAPACITY];
    }


    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.matrixElements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.matrixElements = DEFAULT_CAPACITY_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    //Appends the specified element to the end of this list.
    public void add(T t) {
        matrixElements[size++] = t;
    }

    //Returns the element at the specified position in this list.
    public T get(int index) {
        return (T) matrixElements[index];
    }

}
