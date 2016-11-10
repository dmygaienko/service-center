package com.mygaienko.dao;

import com.mygaienko.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

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

    public RequestEntity findById(long requestId) {
        return entityManager.find(RequestEntity.class, requestId);
    }

    public RequestEntity findByAttributes(RequestEntity request) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RequestEntity> query = builder.createQuery(RequestEntity.class);

        Root<RequestEntity> root = query.from(RequestEntity.class);

        if (request.getClient() != null) {
            query.where(builder.equal(root.get(RequestEntity_.client), request.getClient()));
        }
        if (request.getStatus() != null) {
            query.where(builder.equal(root.get(RequestEntity_.status), request.getStatus()));
        }
        if (request.getType() != null) {
            query.where(builder.equal(root.get(RequestEntity_.type), request.getType()));
        }

        Join<RequestEntity, ProductEntity> productJoin = null;
        if (!StringUtils.isEmpty(request.getProductName())) {
            productJoin = root.join(RequestEntity_.product);
            query.where(builder.like(productJoin.get(ProductEntity_.name), request.getProductName()));
        }

        if (!StringUtils.isEmpty(request.getMakerName())) {
            if (productJoin == null) {
                productJoin = root.join(RequestEntity_.product);
            }

            Join<ProductEntity, MakerEntity> makerJoin = productJoin.join(ProductEntity_.maker);
            query.where(builder.like(makerJoin.get(MakerEntity_.name), request.getMakerName()));
        }

        return entityManager.createQuery(query).getSingleResult();
    }

}
