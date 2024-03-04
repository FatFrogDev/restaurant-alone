package org.globant.restaurantalone.repository.Order;

import org.globant.restaurantalone.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
