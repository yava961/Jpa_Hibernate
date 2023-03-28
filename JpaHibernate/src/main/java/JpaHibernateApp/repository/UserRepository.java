package JpaHibernateApp.repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import JpaHibernateApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

import static JpaHibernateApp.queryConstant.Queries.ALL_PILOTS;
import static JpaHibernateApp.queryConstant.Queries.FIND_BY_EMAIL;

@Repository
public class UserRepository {
    @Autowired
    private EntityManager entityManager;

    public List<Users> findAll() {
        return entityManager.createNativeQuery(ALL_PILOTS, Users.class).getResultList();
    }

    public List<Users> findByEmail(String email) {
        Query query = entityManager.createNativeQuery(FIND_BY_EMAIL, Users.class);
        query.setParameter(1, email);
        return query.getResultList();
    }

    public Users findById(Long id) {
        return entityManager.find(Users.class, id);
    }

    @Transactional
    public Users upsert(Users user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteById(Long id) {
        Users users = entityManager.find(Users.class, id);
        entityManager.remove(users);
    }
}
