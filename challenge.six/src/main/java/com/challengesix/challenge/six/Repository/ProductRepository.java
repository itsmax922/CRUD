package com.challengesix.challenge.six.Repository;

import com.challengesix.challenge.six.model.Products;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {

    public static HashMap<Integer, Products> productMap = new HashMap<>();

    static {
        productMap.put(1, new Products(1, 1000));
        productMap.put(2, new Products(2, 2000));
        productMap.put(3, new Products(3, 3000));
    }

    public static Products getUnitPrice(int productId) {
        return productMap.getOrDefault(productId, null);
    }
}