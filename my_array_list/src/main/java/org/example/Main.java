package org.example;

import org.example.my.list.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> ss = new MyArrayList<>();
        StringBuffer ff = new StringBuffer();
        ff.append("25");
        Entyti entyti = new Entyti("Pablo", 25);
        Grass grass = new Grass("Grass", 1);

        ss.add("1");
        ss.add(entyti.toString());
        ss.add(ff.toString());
        ss.add("4");
        ss.add("5");
        ss.add("6");
        ss.add("7");
        ss.add("8");
        ss.add("9");
        ss.add("10");
        ss.add("11");
        ss.add("12");
        System.out.printf("Element 5 -> %s\n",ss.get(4));
        System.out.printf("Element 6 -> %s\n",ss.get(5));
        ss.add(4,"55");


        System.out.printf("Element 5 -> %s\n",ss.get(4));
        System.out.printf("Element 6 -> %s\n",ss.get(5));

        ss.remove(4);
        System.out.printf("Element 5 -> %s\n",ss.get(4));
        System.out.printf("Element 6 -> %s\n",ss.get(5));

    }

    static class Entyti{
        private String name;
        private int age;
       public Entyti(String name, int age){
            this.name = name;
            this.age = age;
        }
        public String toString(){
            return String.format("Name - %s\nAge - %d", name, age);
        }
    }

    static class Grass extends Entyti{
        public Grass(String name, int age){
            super(name,age);
        }
    }

}