package com.mygaienko.dao;

import com.mygaienko.model.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by enda1n on 09.01.2017.
 */
@Repository
public class ComponentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Component component) {
        entityManager.persist(component);
    }

}
