package org.globant.restaurantalone.service.Client;

import org.globant.restaurantalone.domain.entity.ClientEntity;
import org.globant.restaurantalone.domain.model.ClientDto;
import org.globant.restaurantalone.exceptions.Client.ClientDataInvalidOrIncomplete;
import org.globant.restaurantalone.exceptions.Client.ClientDocumentAlreadyExists;
import org.globant.restaurantalone.exceptions.Client.ClientNotFound;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IClientService {

    ResponseEntity<String> updateByDocument(ClientDto clientDto);

    ResponseEntity<?> deleteByDocument(String document);

    Optional<ClientEntity> findByDocument(String document) throws ClientNotFound;

    ResponseEntity<?> save(ClientDto client) throws ClientDocumentAlreadyExists, ClientDataInvalidOrIncomplete;

}
