package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonExamMain {
    //CRUD
    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, 1L);
            Passport passport = person.getPassport();
            log.info("Person, passport = {}, {}",person.getName(),passport.getPassportNumber());

            Passport passport1 = em.find(Passport.class, 1L);
            Person Person1 = passport1.getPerson();
            log.info("passport1, Person1 = {}, {}",passport1.getPassportNumber(),Person1.getName());

            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = new Person("kwon");
            Passport passport = new Passport("1123131");
            person.setPassport(passport);
            passport.setPerson(person);

            em.persist(person);

            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, 3L);
            person.setName("KWON");

            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, 5L);
            em.remove(person);

            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void deletePassport() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Passport passport = em.find(Passport.class, 4L);
            if(passport != null) {
                passport.getPerson().setPassport(null);
            }
            em.remove(passport);

            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
//        find();
//        create();
//        update();
//        delete();
        deletePassport();
    }
}
