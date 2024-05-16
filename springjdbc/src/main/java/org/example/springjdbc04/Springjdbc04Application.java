package org.example.springjdbc04;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.example.springjdbc03.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class Springjdbc04Application {

    public static void main(String[] args) {
        SpringApplication.run(Springjdbc04Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
            String sql = "SELECT id, name, email FROM users";
            List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
            users.forEach(user -> System.out.println(user));
        };
    }

    private static class UserRowMapper implements RowMapper<User> {
        // 목적: RowMapper는 결과 집합(ResultSet)의 각 행을 개별 객체로 매핑하는 데 사용합니다.
        // 주로 단일 유형의 객체 목록을 반환할 때 사용됩니다. 결과 집합의 각 행마다 한 번씩 메서드가 호출
        // 용도 : 보통 단일 타입의 객체 목록을 반환
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            return new User(id, name, email);
        }
    }
}
