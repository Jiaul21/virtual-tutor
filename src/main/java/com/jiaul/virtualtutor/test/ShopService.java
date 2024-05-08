package com.jiaul.virtualtutor.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopRepo shopRepo;

    public Shop saveShop(Shop shop) {
        System.out.println(shop);
        List<Product> productList = shop.getProduct();

        productList.forEach(product -> {
            product.setShop(shop);
        });
        shop.setProduct(productList);

        System.out.println(shop);
        return shopRepo.save(shop);
    }

    public Shop shopById(int id) {
        return shopRepo.findById(id).orElseThrow();
    }

    public List<Shop> findAll() {
        return shopRepo.findAll();
    }
}
