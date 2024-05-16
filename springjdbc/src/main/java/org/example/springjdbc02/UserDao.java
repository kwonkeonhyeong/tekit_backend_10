package org.example.springjdbc02;

import org.springframework.transaction.annotation.Transactional;

//@Transactional
public interface UserDao {
    void createAndUpdateUser(String name, String email, String newEmail);
}
