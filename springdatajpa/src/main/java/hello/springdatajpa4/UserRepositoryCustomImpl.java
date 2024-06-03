package hello.springdatajpa4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findUsersByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user).where(cb.equal(user.get("name"), name));
        return entityManager.createQuery(query).getResultList();
    }
}
