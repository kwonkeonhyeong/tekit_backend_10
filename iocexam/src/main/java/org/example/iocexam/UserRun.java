package org.example.iocexam;

import org.example.iocexam.config.UserConfig;
import org.example.iocexam.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserRun {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);

        UserController userController = ac.getBean(UserController.class);
        userController.joinUser();

        //
    }
}
