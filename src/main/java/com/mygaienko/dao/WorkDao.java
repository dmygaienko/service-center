package com.mygaienko.dao;

import com.mygaienko.model.Work;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by enda1n on 09.01.2017.
 */
@Repository
public class WorkDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Work work) {
        entityManager.persist(work);
    }

}
