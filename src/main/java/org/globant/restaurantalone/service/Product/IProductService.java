package org.globant.restaurantalone.service.Product;

import org.globant.restaurantalone.domain.entity.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IProductService {
     ResponseEntity<Optional<ProductEntity>> findById(Long id);

     ResponseEntity<?> save(ProductEntity product);
}
