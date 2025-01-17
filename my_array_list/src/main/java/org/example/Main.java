package org.example;

import org.example.my.list.MyArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static MyArrayList<Integer> intList = new MyArrayList<>();
    private static MyArrayList<String> strList = new MyArrayList<>();
    private static MyArrayList<Entyti> entytiList = new MyArrayList<>();

    static {
        intList.add(1);
        intList.add(2);
        intList.add(8);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(2);
        intList.add(12);
        intList.add(12);
        intList.add(11);
        intList.add(9);

        strList.add("Pass");
        strList.add("Fass");
        strList.add("Anana");
        strList.add("Anana");
        strList.add("Anana");
        strList.add("Ananas");
        strList.add("anana");
        strList.add("Volk");
        strList.add("Loup");
        strList.add("Ivan");
        strList.add("Ivaanka");

        entytiList.add(new Grass("Fass", 1));
        entytiList.add(new Grass("Anana", 2));
        entytiList.add(new Grass("Anana", 1));
        entytiList.add(new Grass("Anana", 1));
        entytiList.add(new Grass("Ananas", 5));
        entytiList.add(new Entyti("anana", 3));
        entytiList.add(new Entyti("Volk", 6));
        entytiList.add(new Entyti("Loup", 4));
        entytiList.add(new Entyti("Ivan", 25));
        entytiList.add(new Entyti("Ivaanka", 54));
        entytiList.add(new Grass("Pass", 3));

        print(intList);
        addMyArrayList(5, intList);
        addMyArrayList(15, intList);
        addMyArrayList(51, intList);

        print(intList);
        addForIndexMyArrayList(5, intList, 2);
        addForIndexMyArrayList(15, intList, 3);
        addForIndexMyArrayList(51, intList, 4);
        print(intList);

        print(strList);
        addMyArrayList("5", strList);
        addMyArrayList("15", strList);
        addMyArrayList("51", strList);
        print(strList);


        addForIndexMyArrayList("5", strList, 2);
        addForIndexMyArrayList("15", strList, 3);
        addForIndexMyArrayList("51", strList, 4);
        print(strList);

        print(entytiList);
        addMyArrayList(new Grass("Fass", 1), entytiList);
        addMyArrayList(new Grass("Anana", 2), entytiList);
        addMyArrayList(new Grass("Anana", 1), entytiList);


        print(entytiList);
        addForIndexMyArrayList(new Grass("Fass", 15), entytiList, 2);
        addForIndexMyArrayList(new Grass("Anana", 15), entytiList, 3);
        addForIndexMyArrayList(new Grass("Anana", 15), entytiList, 4);
        print(entytiList);
    }

    public static void main(String[] args) {
        List<MyArrayList> morList = new ArrayList<>();
        morList.add(intList);
        morList.add(strList);
        morList.add(entytiList);



        for (int i = 0; i < morList.size() ; i++) {
            chekList(morList.get(i));
        }


        addForIndexMyArrayList(new Grass("Fass", 15), entytiList, 2);
        addForIndexMyArrayList(new Grass("Anana", 15), entytiList, 3);
        addForIndexMyArrayList(new Grass("Anana", 15), entytiList, 4);
        print(entytiList);

        sortComparator(entytiList, new EntytiComparator());
        print(entytiList);

        for (int i = 0; i < morList.size() ; i++) {
            morList.get(i).clear();
            print(morList.get(i));
        }
    }

    private static <T> void chekList(MyArrayList<T> list) {

        print(list);
        sortComparable(list);

        print(list);
        delet(list, 1);

    }

    private static <T> void addMyArrayList(T element, MyArrayList<T> list) {
        list.add(element);
    }

    private static <T> void addForIndexMyArrayList(T element, MyArrayList<T> list, int index) {
        list.add(index, element);
    }

    private static <T> void sortComparable(MyArrayList<T> list) {
        list.quickSort();
    }

    private static <T> void sortComparator(MyArrayList<T> list, Comparator<T> com) {
        list.quickSort(com);
    }

    private static <T> void print(MyArrayList<T> list) {
        for (int i = 0; i < list.size; i++) {
            System.out.printf("Element %d -> %s\n", i, list.get(i));
        }
        System.out.println("-------------------");
    }

    private static <T> void delet(MyArrayList<T> list, int index) {
        list.remove(index);
    }

    private static <T> void clean(MyArrayList<T> list) {
        list.clear();
    }

    static class Entyti implements Comparable<Entyti> {
        private String name;
        private Integer age;
        private static int count;
        private final Integer id = ++count;

        private static final String NAME = "Name -";
        private static final String AGE = "Age -";
        private static final String ID = "Id -";


        public Entyti(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return String.format("%s %s\n%19s %d\n%19s %d", NAME, name, AGE, age, ID, id);
        }

        @Override
        public int compareTo(Entyti o) {
            int result = this.name.toLowerCase().compareTo(o.name.toLowerCase());
            if (result != 0) {
                return result;
            }
            result = this.age.compareTo(o.age);
            if (result != 0) {
                return result;
            }
            return this.id.compareTo(o.id);
        }
    }

    static class Grass extends Entyti {
        public Grass(String name, int age) {
            super(name, age);
        }
    }

    static class EntytiComparator implements Comparator<Entyti> {
        @Override
        public int compare(Entyti o1, Entyti o2) {
            return o1.id.compareTo(o2.id);
        }
    }

}