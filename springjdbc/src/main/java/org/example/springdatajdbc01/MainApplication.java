package org.example.springdatajdbc01;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
//            for (User user : userRepository.findAll()) {
//                System.out.print(user.getId() + "\t");
//                System.out.print(user.getName() + "\t");
//                System.out.println(user.getEmail());
//            }
            PageRequest pageRequest = PageRequest.of(1,4);
            Page<User> allUser = userRepository.findAllUsersWithPagination(pageRequest);

            allUser.forEach(user -> System.out.println(user.getName()+ " - " + user.getEmail()));
        };
    }

    @Bean
    public CommandLineRunner batchUpdateDemo(JdbcTemplate jdbcTemplate) {
        return args -> {
            List<User> users = Arrays.asList(
                    new User(null, "Alice", "alice@example.com"),
                    new User(null, "Bob", "bob@example.com"),
                    new User(null, "Charlie", "charlie@example.com"),
                    new User(null, "David", "david@example.com")
            );

            String sql = "INSERT INTO users (name,email) VALUES (?, ?)";

            int[] updateCounts = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User user = users.get(i);
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getEmail());
                }

                public int getBatchSize() {
                    return users.size();
                }
            });
        };
    }
}
