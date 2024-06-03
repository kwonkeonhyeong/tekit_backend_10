package hello.springdatajpa2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class CustomerRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void beforeEach() {
        Customer customer = new Customer("kwon1", "kwon1@email.com", 29);
        customerRepository.save(customer);
    }

    @Test
    @DisplayName("Customer 저장 확인")
    void save() {
        assertThat(customerRepository.findByName("kwon1")).isNotNull();
    }

    @Test
    @DisplayName("이름으로 조회")
    void findByName() {
        assertThat(customerRepository.findByName("kwon1").getName()).isEqualTo("kwon1");
    }

    @Test
    @DisplayName("이름으로 Customer 삭제하기")
    void delete() {
        customerRepository.deleteByName("kwon1");

        assertThat(customerRepository.findByName("kwon1")).isNull();
    }

    @Test
    @DisplayName("특정 문자열이 포함된 이메일인 Customer 찾기")
    void findByEmailLike() {
        assertThat(customerRepository.findByEmailLike("%email.com%").size()).isEqualTo(2);
    }

    @Test
    void findByEmailContaining() {
        // Given
        Customer customer1 = new Customer("user1", "user1@test.com", 20);
        Customer customer2 = new Customer("user2", "user2@test.com", 20);
        Customer customer3 = new Customer("user3", "user3@test.com", 20);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        // When
        List<Customer> customers = customerRepository.findByEmailContaining("test");

        // Then
        assertThat(customers.size()).isEqualTo(3);

    }


    @Test
    @DisplayName("고객과 그들의 주문 수 계산하기")
    void findCustomerOrderCountTest() {
        List<Object[]> customerOrderCount = customerRepository.findCustomerOrderCount();
        for (Object[] objects : customerOrderCount) {
            log.info("CustomerName : {}, OrderCount : {}",((Customer) objects[0]).getName(), objects[1]);
        }
    }

    @Test
    @DisplayName("고객의 세부 정보와 그들의 가장 최근 주문 조회")
    void findCustomerWithLatestOrder() {
        List<Object[]> customerWithLatestOrder = customerRepository.findCustomerWithLatestOrder();
//        customerWithLatestOrder.
    }

    @Test
    @SqlGroup({
            @Sql(value = "classpath:db/test.sql",
                    config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
                    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    })
    void findCustomersOlderThanAverageTest() {
        List<Customer> customersOlderThanAverage = customerRepository.findCustomersOlderThanAverage();

        assertThat(customersOlderThanAverage).hasSize(5)
                .extracting(Customer::getName)
                .contains("최지현");
    }

    @Test
    @SqlGroup({
            @Sql(value = "classpath:db/test.sql",
                    config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
                    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    })
    void findCustomerOlderThanAverage() {

    }
}