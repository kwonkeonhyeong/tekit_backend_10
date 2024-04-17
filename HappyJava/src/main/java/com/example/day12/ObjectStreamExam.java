package com.example.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamExam {
    public static void main(String[] args) {
        // 객체를 파일에 저장!!!
//        Person person = new Person("kang", 20);
//
//        try (
//                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.txt"));
//        ) {
//            out.writeObject(person);
//        }
//        catch (IOException e) {}

        // 파일에서 객체를 읽어오기!!!
        Person readPerson = null;
        try(
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.txt"))
                ) {
            readPerson = (Person) in.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(readPerson);
        System.out.println(readPerson.getName());
        System.out.println(readPerson.getAge());
    }
}
