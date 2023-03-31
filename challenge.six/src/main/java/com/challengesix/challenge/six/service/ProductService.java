package com.challengesix.challenge.six.service;

import com.challengesix.challenge.six.Repository.ProductRepository;
import com.challengesix.challenge.six.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private static ProductRepository productRepository;

    public Products insertProduct(Products product) {
        // code to insert product
        Products products = new Products(product.getProduct_id(), product.getUnit_price());
        return products;
    }

    public Products updateProduct(int productId, int unitPrice) {
        // code to update product
        Products products = ProductRepository.productMap.get(productId);
        products.setUnit_price(unitPrice);
        return products;
    }

    public void deleteProduct(int productId) {
        // code to delete product
        ProductRepository.productMap.remove(productId);
    }

}
