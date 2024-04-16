package com.example.day11.exam3;
import java.util.*;

class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " by " + author + " at " + year;
    }

    @Override
    public int compareTo(Book o) {
        return this.year - o.year;
    }
}

class BookManager {
    private List<Book> books;
    
    public BookManager() {
        books = new ArrayList<>();
    }


    public void addBook(Book book) {
        System.out.println("책을 추가했습니다.");
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("책 정보를 확인합니다.");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void sortBooksByYear() {
        Collections.sort(books);
        System.out.println(books);
    }
}

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book("모두의 자바", "강경미", 2015));
        manager.addBook(new Book("이거이 자바다", "신용권", 2018));
        manager.addBook(new Book("자바의 정석", "남궁성", 2013)); // 중복 추가 시도

        manager.displayBooks();
        manager.sortBooksByYear();
    }
}