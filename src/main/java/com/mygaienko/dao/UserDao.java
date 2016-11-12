package com.mygaienko.dao;

import com.mygaienko.model.User;
import com.mygaienko.model.User_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by enda1n on 09.11.2016.
 */
@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public User getByFirstName(String firstName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);

        Root<User> root = query.from(User.class);
        query.where(builder.equal(root.get(User_.firstName), firstName));

        return entityManager.createQuery(query).getSingleResult();
    }

    public User load(long id) {
        return entityManager.getReference(User.class, id);
    }

}
