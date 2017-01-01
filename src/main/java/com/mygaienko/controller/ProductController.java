package com.mygaienko.controller;

import com.mygaienko.model.Product;
import com.mygaienko.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by enda1n on 01.01.2017.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public void createProduct(Product product) {}

    public void editProduct(Product product) {}

    public void deleteProduct(Product product) {}
}
