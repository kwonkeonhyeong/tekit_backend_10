package org.example.iocexam.config;

import org.example.iocexam.controller.UserController;
import org.example.iocexam.dao.UserCaramiDaoImpl;
import org.example.iocexam.dao.UserDao;
import org.example.iocexam.dao.UserDaoImpl;
import org.example.iocexam.service.UserService;
import org.example.iocexam.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.iocexam")
public class UserConfig {
    //IOC 컨테이너에 Bean을 등록하는 방법을 생각해보고 동작될 수 있도록 작성
    // 1. javaconfig를 이용해서 동작되도록!!
//    @Bean
//    public UserController userController(UserService userService) {
//        return new UserController(userService);
//    }
//
//    @Bean
//    public UserService userService(UserDao userDao) {
//        // UserServiceImpl userService = new UserServiceImpl();
//        // // userDao 값을 넣어주는 setter 메서드 필요.
//        // userService.serUserDao(userDao);
//        // return userService;
//        return new UserServiceImpl(userDao);
//    }
//
//    @Bean
//    public UserDao userDao() {
//        return new UserCaramiDaoImpl();
//    }
//    // 2. componentScan을 이용해서 동작되로록!!!

}
