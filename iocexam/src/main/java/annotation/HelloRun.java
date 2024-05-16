package annotation;

import java.lang.reflect.Method;

public class HelloRun {
    public static void main(String[] args) throws Exception {
        Hello hello = new Hello();

        Method declaredMethod = hello.getClass().getDeclaredMethod("print");

        if(declaredMethod.isAnnotationPresent(Count100.class)) {
            for (int i = 0; i < 10; i++) {
                hello.print();
            }
        } else {
            hello.print();
        }
    }
}
