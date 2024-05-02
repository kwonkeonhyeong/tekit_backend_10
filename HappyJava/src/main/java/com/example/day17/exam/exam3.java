package com.example.day17.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class exam3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        // Student에 Comparable 구현
        students.stream().filter(x -> x.getScore() >= 80).sorted().forEach(System.out::println);
        // Comparable 구현 없이 이름으로 비교
        students.stream().filter(x -> x.getScore() >= 80).map(Student::getName).sorted().forEach(System.out::println);
        students.stream().filter(x -> x.getScore() >= 80).sorted(comp).forEach(System.out::println);

    }

    public static Comparator<Student> comp = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName())*-1;
        }
    };
}
