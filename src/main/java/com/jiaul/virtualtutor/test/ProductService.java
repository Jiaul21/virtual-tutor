package com.jiaul.virtualtutor.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public Product productById( int id){
        return productRepo.findById(id).orElseThrow();
    }
}
