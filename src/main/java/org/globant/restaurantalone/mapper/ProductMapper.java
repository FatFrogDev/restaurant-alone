package org.globant.restaurantalone.mapper;

import lombok.extern.log4j.Log4j2;
import org.globant.restaurantalone.domain.entity.ProductEntity;
import org.globant.restaurantalone.helpers.HelperMapper;
import org.globant.restaurantalone.domain.model.ProductDto;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ProductMapper {
    public ProductDto convertProductEntityToProductDTO(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        try {
            productDto= HelperMapper.modelMapper().map(productEntity, ProductDto.class);
        } catch (Exception e) {
            log.error("Error");
        }
        return productDto;
    }
}
