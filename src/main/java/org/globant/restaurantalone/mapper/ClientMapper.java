package org.globant.restaurantalone.mapper;

import lombok.extern.log4j.Log4j2;
import org.globant.restaurantalone.domain.entity.ClientEntity;
import org.globant.restaurantalone.helpers.HelperMapper;
import org.globant.restaurantalone.domain.model.ClientDto;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ClientMapper {
    public ClientDto convertClientEntityToClientDTO(ClientEntity clientEntity) {
        ClientDto clientDto = new ClientDto();
        try {
            clientDto= HelperMapper.modelMapper().map(clientEntity, ClientDto.class);
        } catch (Exception e) {
            log.error("Error");
        }
        return clientDto;
    }

public ClientEntity convertClientDTOToClientEntity(ClientDto clientDto) {
        ClientEntity clientEntity = new ClientEntity();
        try {
            clientEntity = HelperMapper.modelMapper().map(clientDto, ClientEntity.class);
        } catch (Exception e) {
            log.error("Error");
        }
        return clientEntity;
    }
}
