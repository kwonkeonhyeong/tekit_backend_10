package hello.springdatajpa3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class UserRepositoryTest{
    @Autowired
    private UserRepository repository;

    @BeforeEach
    void beforeEach() {
        User user1 = new User("권뭉치", "mong@nameber.com");
        User user2 = new User("구름이", "cloud@nameber.com");
        User user3 = new User("까루", "black@nameber.com");
        repository.save(user1);
        repository.save(user2);
        repository.save(user3);
    }

    @Test
    @DisplayName("네이티브 SQL 사용자 조회")
    void findByEmailNative() {
        List<User> byEmailNative = repository.findByEmailNative("mong@nameber.com");

        assertThat(byEmailNative.size()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("네이티브 쿼리를 사용하여 특정 칼럼을 조회")
    void findUserByNameNative() {
        List<Object[]> users = repository.findUserByNameNative("권뭉치");

//        assertThat(users).extracting(User::getName).c
    }

}