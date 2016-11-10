package com.mygaienko.dao;

import com.mygaienko.model.UserEntity;
import com.mygaienko.model.UserEntity_;
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

    public void createUser(UserEntity user) {
        entityManager.persist(user);
    }

    public UserEntity getByFirstName(String firstName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);

        Root<UserEntity> root = query.from(UserEntity.class);
        query.where(builder.equal(root.get(UserEntity_.firstName), firstName));

        return entityManager.createQuery(query).getSingleResult();
    }

    public UserEntity load(long id) {
        return entityManager.getReference(UserEntity.class, id);
    }

}
