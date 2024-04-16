package com.example.day11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IteratorExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");

        Iterator<String> iter = set.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        for (String str : set) { // foreach java version 5에서 추가!!
            System.out.println(str);
        }

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("pear");

        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }
    }
}
