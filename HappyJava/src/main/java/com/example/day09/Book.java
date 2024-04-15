package com.example.day09;

public class Book {
    private String title;
    private Author author;

    public Book(String title) {
        this.title = title;
        this.author = new Author();
    }

    public String getAuthor() {
        return author.getAuthor();
    }

    public void setAuthor(String  name) {
        author.setAuthor(name);
    }

    public void printBookDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author = " + getAuthor());
    }

    public class Author {
        private String author;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    public static void main(String[] args) {
        Book book = new Book("Book Title");
        book.setAuthor("Author");
        book.printBookDetails();
    }
}
