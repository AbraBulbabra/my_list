package org.example.my.list;

public class MyArrayList<T> {
    // Default size capacity my ArrayList.
    private static final int DEFAULT_CAPACITY = 10;

    //Default capacity for empty list.
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    // The array buffer into which the elements of the ArrayList.
    private Object[] matrixElements;

    // Count element in matrixElements.
    private int size;

    public MyArrayList() {
        this.matrixElements = new Object[DEFAULT_CAPACITY];
    }


    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.matrixElements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.matrixElements = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    //Appends the specified element to the end of this list.
    public void add(T t) {
        if(size == matrixElements.length) {
            extensionMatrix();
        }
        matrixElements[size++] = t;
    }


    //Returns the element at the specified position in this list.
    public T get(int index) {
        return (T) matrixElements[index];
    }

    //todo implement dynamic array expansion
    private void extensionMatrix() {
        if (isSizeMatrixElementsNotZeroOrEmpty()) {
            matrixElements = copyMatrixElement(newLength());
        } else {
            matrixElements = new Object[newLength()];
        }
    }

    // Copy old matrix in new extension matrix.
    private Object[] copyMatrixElement(int newLength) {
        int oldLength = matrixElements.length;
        Object[] newMatrix = new Object[newLength];
        
        for (int i = 0; i < size; i++) {
            newMatrix[i] = matrixElements[i];
        }

        return newMatrix;
    }

    // Expanding array by min max amount.
    private int newLength() {
        int oldLength = matrixElements.length;
        int minExtension = size + 1;
        int bestExtension = oldLength >> 1;

        if (isSizeMatrixElementsNotZeroOrEmpty()) {
            return Math.max((oldLength + minExtension), (oldLength + bestExtension));
        }
        return Math.max(DEFAULT_CAPACITY, minExtension);
    }

    // Return true if matrixElement > 0 or Not DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA.
    private boolean isSizeMatrixElementsNotZeroOrEmpty() {
        return matrixElements.length > 0 || matrixElements != DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

}
