package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class UserRun {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = emf.createEntityManager();

        // 엔티티 생성 -- 아직은 영속성 컨텍스트가 관리하지 않는 상태!!(비영속)
        User user = new User();
//        user.setId(2L);
        user.setName("aomf");
        user.setEmail("fdsf@naver.com");

        // 여기까지도 영속성 컨텍스트가 관리하지는 않음.
        entityManager.getTransaction().begin();

        // 영속성 컨텍스트에게 관리를 맡김. (영속상태)
//        entityManager.persist(user);
//        System.out.println("userId :::::::::::::" + user.getId());

        User user1 = entityManager.find(User.class, 1L);
        User user2 = entityManager.find(User.class, 1L);

        if (user1 == user2) {
            System.out.println("user1 == user2");
            // 영속성 컨텍스트에 처음 불러온 값이 넣어지고 두번째 user2를 불러올때 이미 1번 아이디의 user가
            // 영속성 컨텍스트에 들어있기 때문에 같은 인스턴스를 반환한다.
        } else {
            System.out.println("user1 != user2");
        }

        // 이때 DB에 저장함.
        entityManager.getTransaction().commit();
    }
}
