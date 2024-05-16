package org.example.springjdbc03;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springjdbc03Application {

    public static void main(String[] args) {
        SpringApplication.run(Springjdbc03Application.class, args);
    }

    @Bean
    public CommandLineRunner transactionDemo(UserService userService) {
        return args -> {
            try {
                userService.executeComplexBusinessProcess("rjsgud156333","rjsgud1rf56@exam.xom");
                userService.executeComplexBusinessProcess("Error User","error@exam.xom");
            } catch (Exception e) {
                System.out.println("Exception caught during operations" + e.getMessage());
            }
        };
    }
}
