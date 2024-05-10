package sample2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import sample2.book.Book;

@ComponentScan(basePackages = "sample2")
public class BookConfig {
//    @Bean
//    public Book Book() {
//        return new Book("스프링은 쉽다", 10000);
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Book newBook() {
//        return new Book();
//    }
}
