package hello.springdatajpa3;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    // 네이티브 SQL을 사용한 사용자 조회
    @Query(value = "SELECT * FROM jpa_user WHERE email LIKE %?1%", nativeQuery = true)
    List<User> findByEmailNative(String email);

    @Query(value="SELECT COUNT(*) FROM jpa_user WHERE age > 30 AND status = 'ACTIVE'",nativeQuery = true)
    int countActiveUserOlderThan30();

    // 네이티브 쿼리를 사용하여 특정 칼럼을 조회하는 예제 Object[]을 여러개 List로 반환한다.
    @Query(value="SELECT name, email FROM jpa_user WHERE LIKE %:name%", nativeQuery = true)
    List<Object[]> findUserByNameNative(@Param("name") String name);
}
