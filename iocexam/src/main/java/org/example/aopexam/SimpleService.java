package org.example.aopexam;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String doSomething() {
        // 핵심 관심. target
        System.out.println("SimpleService doSomething run");
        return "Doing somethis...";
    }

    public void hello() {
        System.out.println("hello method run@@@");
        if(1==1) {
            throw new RuntimeException();
        }
    }
}
