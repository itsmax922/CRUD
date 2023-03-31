package com.challengesix.challenge.six.controller;

import com.challengesix.challenge.six.model.Products;
import com.challengesix.challenge.six.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Products> insertProduct(@RequestBody Products product) {
        productService.insertProduct(product);
        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Products> updateProduct(@RequestParam int productId, @RequestParam int unitPrice) {
        Products products = productService.updateProduct(productId, unitPrice);
        return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
    }

}
