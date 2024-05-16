package org.example.springdatajdbc01;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>, CustomUserRepository {
    List<User> findByName(String name);
}
