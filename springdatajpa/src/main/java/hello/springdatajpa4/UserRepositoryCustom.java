package hello.springdatajpa4;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUsersByName(String name);
}
