package com.jiaul.virtualtutor.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class Controller {

    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductService productService;


    @PostMapping("/save/product")
    public ResponseEntity<Product> saveProducts(@RequestBody Product product){
        System.out.println(product);
        return ResponseEntity.ok(productService.saveProduct(product));
    }
    @PostMapping("/product/{id}")
    public ResponseEntity<Product> productById(@PathVariable int id){
        return ResponseEntity.ok(productService.productById(id));
    }

    @PostMapping("/save/shop")
    public ResponseEntity<Shop> saveShops(@RequestBody Shop shop){
        System.out.println(shop);
        return ResponseEntity.ok(shopService.saveShop(shop));
    }
    @PostMapping("/shop")
    public ResponseEntity<Shop> shopById(@RequestParam int id){
        return ResponseEntity.ok(shopService.shopById(id));
    }
    @GetMapping("/shop/all")
    public ResponseEntity<List<Shop>> shopAll(){
        return ResponseEntity.ok(shopService.findAll());
    }


}
