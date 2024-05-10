package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
        // 직접 사용하는 경우!!
        // MyBean bean = new MyBean();
        // bean.setName("kang");

        // System.out.println(bean);

        // 스프링 ioc container를 이용해서 사용하는 경우
        // 스프링 컨테이너에게 알려줘야 하지 않을까요??
        // 1. 애노테이션으로 알려줌.  -- 컴포넌트 스캔 하도록!!
        // 2. 자바파일을 통해서 알려줌

        // BeanFactory -- 빈을 생성하는데 간단한 기능만 포함하고 있다. aop 기술은 사용할 수 없어요!!
        System.out.println("ApplicationContext 생성전!!");
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyBeanConfig.class);
        System.out.println("ApplicationContext 생성후!!");
        MyBean bean1 = (MyBean) ac.getBean("myBean"); // lookup 방식..
        bean1.setName("carami");

//        MyBean bean2 = ac.getBean(MyBean.class); // 타입만 알려줌 but, 같은 타입의 빈이 여러 개 있으면 에러난다.

//        bean2.setName("kim");

        MyBean bean3 = ac.getBean("myBean", MyBean.class);
        MyBean bean4 = ac.getBean("myBean2", MyBean.class);

        System.out.println(bean1);
//        System.out.println(bean2);
        System.out.println(bean3);
        System.out.println(bean4);

        if(bean1 == bean4) {
            System.out.println("1과 4는 같은 인스턴스입니다.");
        } else {
            System.out.println("1과 4는 다른 인스턴스입니다.");
        }

        if(bean1 == bean3) {
            System.out.println("1과 3는 같은 인스턴스입니다.");
        } else {
            System.out.println("1과 3는 다른 인스턴스입니다.");
        }

        // @Scope("prototype") 일 경우에는 bean이 처음에 생성되는 것이 아니다. getBean 할때마다 새로운 인스턴스가 생성된다.
        MyBean bean5 = ac.getBean("myBean3", MyBean.class);
        bean5.setName("hang");
        System.out.println(bean5);

        MyBean bean6 = ac.getBean("myBean3", MyBean.class);
        bean6.setName("mong");
        System.out.println(bean6);

        // 3. xml을 통해서 알려줌 -- 현재는 많이 사용하지 않음
    }
}
