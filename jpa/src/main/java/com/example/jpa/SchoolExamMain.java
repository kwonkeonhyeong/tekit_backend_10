package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolExamMain {
//    public static void main(String[] args) {
//        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
//
//        em.getTransaction().begin();
//        try {
//
////            School school = em.find(School.class, 1L);
////            log.info("School Name: {}", school.getName());
////
////            for (Student student : school.getStudents()) {
////                log.info("Strudent name : {}", student.getName());
////            }
//            Student student = em.find(Student.class, 5L);
//            log.info("student name : {}" , student.getName());
//            log.info("school name : {}", student.getSchool().getName());
//        } finally {
//            em.close();
//        }
//    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            School school = new School("Lion school");
            Student student1 = new Student("뭉뭉치", school);
            Student student2 = new Student("이나연", school);
            Student student3 = new Student("한승균", school);

            school.getStudents().add(student1);
            school.getStudents().add(student2);
            school.getStudents().add(student3);

            em.persist(school);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            School school = em.find(School.class, 2L);
            school.setName("update school");

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            School school = em.find(School.class, 4L);
            em.remove(school);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
//        create();
//        update();
        delete();
    }
}
