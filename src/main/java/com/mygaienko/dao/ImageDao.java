package com.mygaienko.dao;

import com.mygaienko.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by enda1n on 01.01.2017.
 */
@Repository
public class ImageDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Image image) {
        entityManager.persist(image);
    }

}
