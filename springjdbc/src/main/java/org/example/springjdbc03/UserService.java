package org.example.springjdbc03;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
@RequiredArgsConstructor
public class UserService {
    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionalTemplate;

    public void executeComplexBusinessProcess(String name, String email) {
        transactionalTemplate.execute(status -> {
            jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?, ?)", name, email);
            if(email.contains("error")) {

            status.setRollbackOnly();
            throw new RuntimeException("Simulated error to trigger rollback");
            }
            jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?","rjsgud1956342@gmg.fsdf", name);
            return null;
        }
        );
    }
}
