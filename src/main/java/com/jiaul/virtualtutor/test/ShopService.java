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
//        List<Product> productList = shop.getProduct();
//        shop.setProduct(null);
//        System.out.println(shop);
//        productList.forEach(product -> {
//            System.out.println("*******************");
//            product.setShop(shop);
//            System.out.println(product);
//        });
//        System.out.println("@@@@@@@@@@");
//        shop.setProduct(productList);
//        System.out.println("@@@@@@@@@@");
//        System.out.println(productList);


//        System.out.println(shop);
        return shopRepo.save(shop);
    }

    public Shop shopById(int id) {
        return shopRepo.findById(id).orElseThrow();
    }

    public List<Shop> findAll() {
        return shopRepo.findAll();
    }
}
