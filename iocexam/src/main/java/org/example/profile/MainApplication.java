package org.example.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(MainApplication.class, args);
        DataService bean = ac.getBean(DataService.class);
        System.out.println(bean.getEnvironment());
    }
}
