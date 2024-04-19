package com.test_deploy.controller;

import com.test_deploy.entity.Product;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> products;
    public ProductController(){
        products = Arrays.asList(
                Product.builder()
                        .id(1L)
                        .name("Product 1")
                        .price(250).build(),
                Product.builder()
                        .id(2L)
                        .name("Product 2")
                        .price(550).build(),
                Product.builder()
                        .id(3L)
                        .name("Product 3")
                        .price(749).build()

        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
        System.out.println("testing");
        var data = products.stream().filter(x->x.getId().equals(id)).findFirst().get();
        return ResponseEntity.ok(data);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getall(){
        return ResponseEntity.ok(products);
    }
}
