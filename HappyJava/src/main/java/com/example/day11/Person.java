package com.example.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }

    @Override
    public int compareTo(Person o) {
        // return this.age - o.age; // 나이를 기준으로 오름차순 정렬.
        return this.name.compareTo(o.name); // 이름을 기준으로 오름차순 정렬.
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("kang", 30));
        list.add(new Person("kim", 20));
        list.add(new Person("hang", 43));
        list.add(new Person("jang", 78));

        System.out.println(list);
        Collections.sort(list);

        System.out.println(list);

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println(list);
    }
}
