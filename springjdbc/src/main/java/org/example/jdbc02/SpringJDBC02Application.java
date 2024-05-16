package org.example.jdbc02;

import org.example.jdbc02.dao.User;
import org.example.jdbc02.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJDBC02Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC02Application.class,args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
            // insert test
            userDao.insertUser(new User(null,"hong","hong121@gmail.com"));

            // select test
            userDao.findAllUsers().forEach(System.out::println);
            // update test
            userDao.updateUserEmail("hong","hong123123@nave.com");

            // delete test
            userDao.deleteUser("hong");

            // select test
            userDao.findAllUsers().forEach(System.out::println);
        };
    }
}
