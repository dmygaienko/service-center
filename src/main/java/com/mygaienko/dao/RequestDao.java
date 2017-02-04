package com.mygaienko.dao;

import com.mygaienko.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by enda1n on 09.11.2016.
 */
@Repository
public class RequestDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void createRequest(Request request) {
        entityManager.persist(request);
    }

    public Request findById(long requestId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        Root<Request> root = query.from(Request.class);
        query.where(builder.equal(root.get(Request_.id), requestId));

        Fetch<Request, Product> productJoin = root.fetch(Request_.product, JoinType.LEFT);
        productJoin.fetch(Product_.maker, JoinType.LEFT);

        root.fetch(Request_.comments, JoinType.LEFT);
        root.fetch(Request_.images, JoinType.LEFT);
        root.fetch(Request_.components, JoinType.LEFT);
        root.fetch(Request_.works, JoinType.LEFT);

        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Request> findByAttributes(Request request) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        Root<Request> root = query.from(Request.class);

        if (request.getClient() != null) {
            query.where(builder.equal(root.get(Request_.client), request.getClient()));
        }
        if (request.getStatus() != null) {
            query.where(builder.equal(root.get(Request_.status), request.getStatus()));
        }
        if (request.getType() != null) {
            query.where(builder.equal(root.get(Request_.type), request.getType()));
        }

        Join<Request, Product> productJoin = null;
        if (!StringUtils.isEmpty(request.getProductName())) {
            productJoin = root.join(Request_.product);
            query.where(builder.like(productJoin.get(Product_.name), request.getProductName()));
        }

        if (!StringUtils.isEmpty(request.getMakerName())) {
            if (productJoin == null) {
                productJoin = root.join(Request_.product);
            }

            Join<Product, Maker> makerJoin = productJoin.join(Product_.maker);
            query.where(builder.like(makerJoin.get(Maker_.name), request.getMakerName()));
        }

        return entityManager.createQuery(query).getResultList();
    }

    public List<Request> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        Root<Request> root = query.from(Request.class);

        Fetch<Request, Product> productJoin = root.fetch(Request_.product, JoinType.LEFT);
        productJoin.fetch(Product_.maker, JoinType.LEFT);

        return entityManager.createQuery(query).getResultList();
    }

    public List<Request> getLatest() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Request> query = builder.createQuery(Request.class);

        Root<Request> root = query.from(Request.class);
        query.orderBy(builder.desc(root.get(Request_.datetime)));

        Fetch<Request, Product> productJoin = root.fetch(Request_.product, JoinType.LEFT);
        productJoin.fetch(Product_.maker, JoinType.LEFT);

        return entityManager.createQuery(query).setFirstResult(0).setMaxResults(20).getResultList();
    }

    public void update(Request request) {
        entityManager.merge(request);
    }

    public Request load(long id) {
        return entityManager.getReference(Request.class, id);
    }
}
