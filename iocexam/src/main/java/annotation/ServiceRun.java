package annotation;

import java.lang.reflect.Method;

public class ServiceRun {
    public static void main(String[] args) throws Exception {
        Method[] declareMethod = Service.class.getDeclaredMethods();

        Service service = new Service();

        for (Method method : declareMethod) {
            if(method.isAnnotationPresent(PrintAnnotation.class)) {
                System.out.println("[[[[[[[[[["+method.getName()+"]]]]]]]]]");

                PrintAnnotation annotation = method.getAnnotation(PrintAnnotation.class);

                for(int i = 0; i < annotation.number(); i++) {
                    System.out.print(annotation.value());
                }
                System.out.println();
            }
            method.invoke(service);
        }
    }
}
