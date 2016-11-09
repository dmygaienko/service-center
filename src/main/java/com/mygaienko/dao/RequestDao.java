package com.mygaienko.dao;

import com.mygaienko.model.RequestEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by enda1n on 09.11.2016.
 */
@Repository
public class RequestDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createRequest(RequestEntity request) {
        entityManager.persist(request);
    }
}
