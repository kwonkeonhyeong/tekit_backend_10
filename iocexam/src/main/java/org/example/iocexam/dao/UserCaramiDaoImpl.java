package org.example.iocexam.dao;

import java.util.List;
import org.example.iocexam.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserCaramiDaoImpl implements UserDao{
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "의 정보를 CaramiDao를 통해 잘 저장했습니다.");
    }
}
