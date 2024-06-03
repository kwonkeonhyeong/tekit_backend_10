package hello.springdatajpa2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jpa_order")
@NoArgsConstructor
@Getter @Setter
public class Order {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(String product, LocalDateTime date, Customer customer) {
        this.product = product;
        this.date = date;
        this.customer = customer;
    }
}
