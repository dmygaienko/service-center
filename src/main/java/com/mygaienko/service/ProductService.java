package com.mygaienko.service;

import com.mygaienko.dao.ProductDao;
import com.mygaienko.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 01.01.2017.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void createProduct(Product product) {};

    public void editProduct(Product product) {};

    public void deleteProduct(Product product) {};
}
