package org.example;

import org.example.my.list.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> ss = new MyArrayList<>();
        StringBuffer ff = new StringBuffer();
        ff.append("25");
        Entyti entyti = new Entyti("Pablo", 25);


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

        System.out.println(ss.get(0));
        System.out.println(ss.get(1));
        System.out.println(ss.get(2));

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

}