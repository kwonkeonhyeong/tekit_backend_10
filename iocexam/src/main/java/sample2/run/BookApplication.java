package sample2.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample2.book.Book;
import sample2.config.BookConfig;


public class BookApplication {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(BookConfig.class);

        Book book1 = ac.getBean("book", Book.class);
        System.out.println(book1);

        Book book2 = ac.getBean("book", Book.class);
        System.out.println(book2);

        Book book3 = ac.getBean("book", Book.class);
        book3.setTitle("오브젝트");
        book3.setPrice(13000);
        System.out.println(book3);

        Book book4 = ac.getBean("book", Book.class);
        book4.setTitle("자바의 정석");
        book4.setPrice(17000);
        System.out.println(book4);

        if(book1 == book2) {
            System.out.println(book1.getTitle() + " 과 " + book2.getTitle() + "은 같은 책입니다.");
        } else {
            System.out.println(book1.getTitle() + " 과 " + book2.getTitle() + "은 다른 책입니다.");
        }

        if(book3 == book4) {
            System.out.println(book3.getTitle() + " 과 " + book4.getTitle() + "은 같은 책입니다.");
        } else {
            System.out.println(book3.getTitle() + " 과 " + book4.getTitle() + "은 다른 책입니다.");
        }
    }
}
