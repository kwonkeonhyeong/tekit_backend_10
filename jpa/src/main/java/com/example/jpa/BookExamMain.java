package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookExamMain {
    public static void main(String[] args) {
//        create();
//        update();
        delete();
    }
    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = new Author("권건형");
            Book book1 = new Book("1번책",author);
            Book book2 = new Book("2번책",author);
            Book book3 = new Book("3번책",author);
            Book book4 = new Book("4번책",author);

            author.getBooks().add(book1);
            author.getBooks().add(book2);
            author.getBooks().add(book3);
            author.getBooks().add(book4);

            em.persist(author);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = em.find(Author.class,4L);
            author.setName("권뭉치");

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Author author = em.find(Author.class,4L);
            em.remove(author);

            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }
}
