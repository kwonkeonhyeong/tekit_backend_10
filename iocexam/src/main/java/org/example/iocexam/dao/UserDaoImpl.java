package org.example.iocexam.dao;

import java.util.List;
import org.example.iocexam.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "의 정보가 잘 저장되었습니다.");
    }
}
