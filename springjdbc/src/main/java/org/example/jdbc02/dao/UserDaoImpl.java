package org.example.jdbc02.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{
    // JDBCTemplate 객체 이용해서 구현
    // 필드 기반
//    @Autowired
    private final JdbcTemplate jdbcTemplate;
    // 생성자 기반
//    @Autowired
//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    // 설장자 기반
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }


    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(name,email) VALUES (?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getEmail());
        System.out.println("name : " + user.getName() + ", email : " + user.getEmail() + "이 입력되었습니다.");
    }

    @Override
    public List<User> findAllUsers() {
        // RowMapper 풀어서 표기하면 아래와 같음
//        RowMapper<User> rowMapper2 = new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new User (
//                rs.getLong("id"),
//                        rs.getString("name"),
//                        rs.getString("email")
//                );
//            }
//        };

        RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
                );
        return jdbcTemplate.query("SELECT id,name,email FROM users",rowMapper);

        // 아래 같이 사용도 가능하다.
        // return jdbcTemplate.query("SELECT id,name,email FROM users",new UserMapper());
    }

    @Override
    public void updateUserEmail(String name, String email) {
        String sql = "UPDATE users SET email=? WHERE name=?";
        jdbcTemplate.update(sql,email,name);
        System.out.println("name : " + name + ", email : " + email + "이 업데이트되었습니다.");
    }

    @Override
    public void deleteUser(String name) {
        String sql = "DELETE FROM users WHERE name=?";
        jdbcTemplate.update(sql,name);
        System.out.println("name : " + name + "이 삭제되었습니다.");
    }

    class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User (
                rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
        }
    }
}
