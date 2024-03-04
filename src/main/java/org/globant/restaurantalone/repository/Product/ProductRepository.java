package org.globant.restaurantalone.repository.Product;

import org.globant.restaurantalone.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findById(Long id);
}
