package sample2.book;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Book {
    private String title;
    private int price;

    public Book() {
        System.out.println("기본Book 생성!");
    }

    public Book(String title, int price) {
        System.out.println(title + "," + price + "생성!!");
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
