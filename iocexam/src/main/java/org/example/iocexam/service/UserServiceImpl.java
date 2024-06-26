package org.example.iocexam.service;

import org.example.iocexam.dao.UserDao;
import org.example.iocexam.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
    public UserServiceImpl(@Qualifier("userCaramiDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

//    public UserServiceImpl(@Qualifier("userDaoImpl") UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void joinUser(User user) {
        // 회원가입을 위한 비즈니스 코드가 작성되어야 함...
        // 회원가입을 위한 비지니스가 수행되면.. 해당 데이터를 저장하는 코드가 실행
        userDao.addUser(user);
    }
}
