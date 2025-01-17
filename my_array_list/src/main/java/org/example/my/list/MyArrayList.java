package org.example.my.list;

import java.util.Comparator;

public class MyArrayList<T> {
    // Default size capacity my ArrayList.
    private static final int DEFAULT_CAPACITY = 10;

    //Default capacity for empty list.
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    // The array buffer into which the elements of the ArrayList.
    private Object[] matrixElements;

    // Count element in matrixElements.
    public int size;

    public MyArrayList() {
        this.matrixElements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.matrixElements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.matrixElements = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    //Appends the specified element to the end of this list.
    public void add(T t) {
        growMatrix();
        matrixElements[size++] = t;
    }

    // Adds the specified element at index to the list.
    public void add(int index, T element) {

        if (chekIndex(index)) {
            matrixElements = copyMatrixWithStepToRight(index);
            matrixElements[index] = element;
            size++;
        } else {
            System.err.printf("Out of bounds Check Index -> %d", index);
        }
    }

    private Object[] copyMatrixWithStepToRight(int index) {
        Object[] newObject = createObjectNewLength();

        int add = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                newObject[i] = null;
                add++;
            }

            int newIndex = i + add;
            newObject[newIndex] = matrixElements[i];
        }

        return newObject;
    }

    public void remove(int index) {
        if (chekIndex(index)) {
            copyMatrixWithStepToLeft(index);
            size--;
        } else {
            System.err.printf("Out of bounds Check Index -> %d", index);
        }
    }

    private void copyMatrixWithStepToLeft(int index) {
        Object[] matrixElement = this.matrixElements;
        int oldSize = size;

        int add = 0;
        for (int i = index; i < size; i++) {
            if (i == index) {
                add++;
            }
            int newIndex = i + add;

            this.matrixElements[i] = matrixElements[newIndex];
        }
    }

    private boolean chekIndex(int index) {
        return (index >= 0) && (index < size);
    }

    // Copy matrixElement at new matrix with one step right from index.


    // Creates new matrix with new or old length.
    private Object[] createObjectNewLength() {
        if (isLimitSize()) {
            return new Object[newLength()];
        } else {
            return new Object[matrixElements.length];
        }
    }

    //Returns the element at the specified position in this list.
    public T get(int index) {
        return (T) matrixElements[index];
    }

    public <T> void set(int index, T element) {
        matrixElements[index] = element;
    }

    private void growMatrix() {
        if (isLimitSize()) {
            extensionMatrix();
        }
    }

    private boolean isLimitSize() {
        return size == matrixElements.length;
    }

    //todo implement dynamic array expansion
    private void extensionMatrix() {
        if (isSizeMatrixElementsNotZeroOrEmpty()) {
            matrixElements = copyMatrixElement();
        } else {
            matrixElements = new Object[newLength()];
        }
    }

    // Copy old matrix in new extension matrix.
    private Object[] copyMatrixElement() {
        int oldLength = matrixElements.length;
        Object[] newMatrix = new Object[newLength()];

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

    public void clear() {
        final Object[] es = matrixElements;
        for (int i = 0; i < size; i++) {
            es[i] = null;
        }
        size = 0;
    }

    /**
     * Start sorting
     * <p>
     * *@param start - left border of the array
     * *@param end   - right border of the array
     */
    public <T extends Comparable<T>> void quickSort() {
        int start = 0;
        int end = size - 1;
        quickSort(start, end);
    }


    /**
     * Recursion method
     * <p>
     * *@param partition - index of the already sorted part of the array.
     * everything on the left will always be smaller
     * everything on the right is always bigger
     * *@param start - left border of the array
     * *@param end   - right border of the array
     */
    private <T extends Comparable<T>> void quickSort(int start, int end) {
        int partition = partition(start, end);

        if (partition - 1 > start) {
            quickSort(start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(partition + 1, end);
        }
    }

    /**
     * Sorting method
     * <p>
     * *@param arr - sorting array
     * *@param pivot - element for comparison
     * *@param wall - everything to the left of which the indices are less than Pivot,
     * to the right are greater,
     * at the end at this point they become Pivot
     * *@param end   - right border of the array
     */
    private <T extends Comparable<T>> int partition(int wall, int end) {
        MyArrayList<T> arr = (MyArrayList<T>) this;
        T pivot = arr.get(end);

        for (int i = wall; i < end; i++) {
            if (arr.get(i).compareTo(pivot) < 0) {
                T temp = arr.get(wall);
                arr.set(wall, arr.get(i));
                arr.set(i, temp);
                wall++;
            }
        }


        T temp = arr.get(wall);
        arr.set(wall, pivot);
        arr.set(end, temp);

        return wall;
    }

    /**
     * Start sorting with Comparator
     * <p>
     * *@param start - left border of the array
     * *@param end   - right border of the array
     */
    public <T> void quickSort(Comparator<T> t) {
        int start = 0;
        int end = size - 1;
        quickSort(t, start, end);
    }

    private <T> void quickSort(Comparator<T> t, int start, int end) {
        int partition = partition(t, start, end);

        if (partition - 1 > start) {
            quickSort(t, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(t, partition + 1, end);
        }
    }


    private <T> int partition(Comparator<T> t, int start, int end) {
        MyArrayList<T> arr = (MyArrayList<T>) this;
        T pivot = arr.get(end);

        for (int i = start; i < end; i++) {
            if (t.compare(arr.get(i), pivot) < 0) {
                T temp = arr.get(start);
                arr.set(start, arr.get(i));
                arr.set(i, temp);
                start++;
            }
        }


        T temp = arr.get(start);
        arr.set(start, pivot);
        arr.set(end, temp);

        return start;
    }
}
