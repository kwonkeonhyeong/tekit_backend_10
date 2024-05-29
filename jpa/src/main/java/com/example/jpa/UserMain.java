package com.example.jpa;

import hello.Main;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class UserMain {
//    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
         UserDAO userDAO = new UserDAO();

//        // findUser()
//        log.info("=========findUser()============");
//        User findUser = userDAO.findUser(1L);
//        log.info("Found user : {}", findUser.getName());
//
//        User findUser2 = userDAO.findUser(1L);
//
//        if (findUser == findUser2) {
//            log.info("findUser == findUser2");
//            // 엔티티 매니저가 달라지면 영속성 컨텍스트도 달라져서 두 값이 다르다.
//            // 반면 영속성 컨텍스트가 같은 상황에서는 두 값이 같다고 나올것이다.
//        } else {
//            log.info("findUser != findUser2");
//        }

        User rjsgudUser = new User("rjsgud11", "rjsgud11@fkj.com");

        userDAO.createUser(rjsgudUser);

        log.info("Create user : " + rjsgudUser.getName()); // 연산자는 쓰지 않는 것이 좋다.

        log.info("Create user: {}", rjsgudUser.getName());
        log.info("Create user: {}", rjsgudUser.getEmail());
        log.info("Create user: {}", rjsgudUser.getId());

//        User user = new User();
//        user.setId(1L);
//
//        userDAO.deleteUser(user);
    }
}
