package hello.springdatajpa;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;



@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    @DisplayName("DB save Test")
    void save() {
        User user = new User("mong1", "mong@catcat.com");
        repository.save(user);

        List<User> users = repository.findByName("mong1");

        assertThat(users.size()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("이름을 가진 유저 모두 찾기")
    void findByName() {
        List<User> users = repository.findByName("kwon");
        assertThat(users.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("이메일로 유저 찾기")
    void findByEmail() {
        User user = repository.findByEmail("carami@example.com");
        assertThat(user.getName()).isEqualTo("carami");
    }

    @Test
    @DisplayName("이름, 이메일 일치하는 유저 모두 찾기")
    void findByNameAndEmail() {
        List<User> users = repository.findByNameAndEmail("mong1", "mong1@catcat.com");
        assertThat(users.size()).isEqualTo(2);
    }


    @Test
    @DisplayName("이름, 이메일 돌 중 하나라도 일치하는 유저 모두 찾기")
    void findByNameOrEmail() {
        List<User> users = repository.findByNameOrEmail("rjsgud", "mong1@catcat.com");
        assertThat(users.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("특정 아이디 이메일 변경해보기")
    void updateUserEmail() {
        repository.updateUserEmail(5L, "new_kang@exam.com");

        Optional<User> user = repository.findById(5L);

        assertThat(user.get().getEmail()).isEqualTo("new_kang@exam.com");
    }

    @Test
    @DisplayName("이메일 일치하는 유저 삭제하기")
    void deleteByEmail() {
        repository.deleteByEmail("new_kang@exam.com");

        List<User> user = repository.findAll();
        List<String> userEmailList = user.stream().map(User::getEmail).collect(Collectors.toList());
        assertThat(userEmailList).doesNotContain("new_kang@exam.com");
    }

}