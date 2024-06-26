package org.example.iocexam;

import org.example.iocexam.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IocexamApplication {
    public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(IocexamApplication.class, args);
        UserController bean = ac.getBean(UserController.class);
        bean.joinUser();

    }

}
