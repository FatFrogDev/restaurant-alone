package org.globant.restaurantalone.controller;

import lombok.*;
import org.globant.restaurantalone.domain.entity.ProductEntity;
import org.globant.restaurantalone.service.Product.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    @GetMapping("/{uuid}")
    public ResponseEntity<?> findByUUID() {
        return ResponseEntity.ok(productService.findById(13L));
    }

    @PostMapping("/create")
    public void save(@RequestBody ProductEntity product) { productService.save(product); }


}
