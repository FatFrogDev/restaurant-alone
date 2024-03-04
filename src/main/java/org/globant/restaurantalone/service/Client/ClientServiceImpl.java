package org.globant.restaurantalone.service.Client;

import org.globant.restaurantalone.domain.entity.ClientEntity;
import org.globant.restaurantalone.domain.model.ClientDto;
import org.globant.restaurantalone.exceptions.Client.ClientDataInvalidOrIncomplete;
import org.globant.restaurantalone.exceptions.Client.ClientDocumentAlreadyExists;
import org.globant.restaurantalone.exceptions.Client.ClientNotFound;
import org.globant.restaurantalone.mapper.ClientMapper;
import org.globant.restaurantalone.repository.Client.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {

    ClientRepository clientRepository;
    ClientMapper converter;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper converter) {
        this.clientRepository = clientRepository;
        this.converter = converter;
    }

    @Override // TODO: Refactor
    public ResponseEntity<String> updateByDocument(ClientDto clientDto) {
        Optional<ClientEntity> client = clientRepository.findByDocument(clientDto.getDocument());
        ClientEntity clientConverted = converter.convertClientDTOToClientEntity(clientDto);
        if (client.isPresent()) {
            clientConverted.setUuid(client.get().getUuid());
            System.out.println(clientConverted);
            clientRepository.save(clientConverted);
        };
        return ResponseEntity.ok().body("Client updated");
    }

    @Override
    public ResponseEntity<?> deleteByDocument(String document) {
        clientRepository.deleteByDocument(document);
        return ResponseEntity.ok().body("Client deleted");
    }

    @Override
    public Optional<ClientEntity> findByDocument(String document) throws ClientNotFound {
        Optional<ClientEntity> client = clientRepository.findByDocument(document);
        if (!client.isPresent()){
            throw new ClientNotFound("Client not found, try verifying the document");
        }else return Optional.of(client.get());
    }

    //TODO: Add 400-409-500 possible code status
    @Override
    public ResponseEntity<?> save(ClientDto client) throws ClientDocumentAlreadyExists, ClientDataInvalidOrIncomplete {
        if (clientRepository.findByDocument(client.getDocument()).isPresent()){
            throw new ClientDocumentAlreadyExists("Client with that document already exists.");
        }
        if (client.getFullName().isEmpty() || client.getDocument().isEmpty() || client.getPhone().isEmpty()){
            throw new ClientDataInvalidOrIncomplete("Client data is invalid or incomplete.");
        }
        try {
            clientRepository.save(converter.convertClientDTOToClientEntity(client));
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(clientRepository.findByDocument(client.getDocument()));
        } catch (Exception e){
            return ResponseEntity.status(500).body("Internal server error");
        }
    }
}