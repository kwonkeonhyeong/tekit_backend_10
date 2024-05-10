package org.example.iocexam.dao;

import java.util.List;
import org.example.iocexam.domain.User;
import org.springframework.stereotype.Component;

//@Component
public interface UserDao {
     User getUser(String email);
     List<User> getUsers();
     void addUser(User user);
}
