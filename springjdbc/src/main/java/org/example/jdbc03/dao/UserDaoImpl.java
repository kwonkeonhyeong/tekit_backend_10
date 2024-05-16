package org.example.jdbc03.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.jdbc03.UserNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(name,email) VALUES (?,?)";
        try {
            jdbcTemplate.update(sql,user.getName(),user.getEmail());
        } catch (DataAccessException e) {
            throw new DataAccessException("사용자를 입력하다 오류 발생" + user.getName(),e){};
        }
        System.out.println("name : " + user.getName() + ", email : " + user.getEmail() + "이 입력되었습니다.");
    }

    @Override
    public List<User> findAllUsers() {
        try {
            RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email")
                    );
            return jdbcTemplate.query("SELECT id,name,email FROM users",rowMapper);
        } catch (DataAccessException e) {
            throw new DataAccessException("사용자 조회하다 오류 발행",e) {};
        }


    }

    @Override
    public void updateUserEmail(String name, String email) {
        String sql = "UPDATE users SET email=? WHERE name=?";
        int updated = jdbcTemplate.update(sql,email,name);
        if(updated == 0) {
            throw new UserNotFoundException("No user found with name" + name);
        }
        System.out.println("name : " + name + ", email : " + email + "이 업데이트되었습니다.");
    }

    @Override
    public void deleteUser(String name) {
        String sql = "DELETE FROM users WHERE name = ?";
        int deleted = jdbcTemplate.update(sql, name);
        if(deleted == 0) {
            throw new UserNotFoundException("No user found with name" + name);
        }
        System.out.println("name : " + name + "이 삭제되었습니다.");
    }

}
