package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product update(Product product, String id) {
        Product productOld = productRepository.findById(id).get();
        productOld.setName(product.getName());
        productOld.setPrice(product.getPrice());
        productOld.setQuantity(product.getQuantity());
        productOld.setStorage(product.getStorage());
        productRepository.save(productOld);
        return productOld;
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
}
