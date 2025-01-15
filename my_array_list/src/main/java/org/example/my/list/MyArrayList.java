package org.example.my.list;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    // The array buffer into which the elements of the ArrayList
    private T[] matrixElements;

    private int size;

    public MyArrayList(){
        this.matrixElements = (T[]) new Object[DEFAULT_CAPACITY];
    }



    public MyArrayList(int initialCapacity){
        if (initialCapacity > 0) {
            this.matrixElements = (T[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.matrixElements =(T[]) DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public void add(T t){
        matrixElements[size++] = t;
    }

    public <T> T get(int index){
        return (T) matrixElements[index];
    }

}
