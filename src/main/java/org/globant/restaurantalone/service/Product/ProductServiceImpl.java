package org.globant.restaurantalone.service.Product;


import lombok.AllArgsConstructor;
import org.globant.restaurantalone.domain.entity.ProductEntity;
import org.globant.restaurantalone.repository.Product.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Optional<ProductEntity>> findById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(productRepository.findById(id));
        }else return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<?> save(ProductEntity product) {
        productRepository.save(product);
        return ResponseEntity.ok().body("Product saved");
    }

}
