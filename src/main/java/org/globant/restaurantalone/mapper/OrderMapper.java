package org.globant.restaurantalone.mapper;

import lombok.extern.log4j.Log4j2;
import org.globant.restaurantalone.domain.entity.OrderEntity;
import org.globant.restaurantalone.helpers.HelperMapper;
import org.globant.restaurantalone.domain.model.OrderViewDTO;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class OrderMapper {

    public OrderViewDTO convertOrderEntityToOrderViewDTO(OrderEntity orderEntity) {
        OrderViewDTO orderViewDTO = new OrderViewDTO();
        try {
            orderViewDTO = HelperMapper.modelMapper().map(orderEntity, OrderViewDTO.class);
        } catch (Exception e) {
            log.error("Error");
        }
        return orderViewDTO;
    }
}
