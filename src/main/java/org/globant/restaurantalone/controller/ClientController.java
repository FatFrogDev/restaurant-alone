package org.globant.restaurantalone.controller;


import lombok.AllArgsConstructor;
import org.globant.restaurantalone.domain.model.ClientDto;
import org.globant.restaurantalone.exceptions.Client.ClientDataInvalidOrIncomplete;
import org.globant.restaurantalone.exceptions.Client.ClientNotFound;
import org.globant.restaurantalone.exceptions.Client.ClientDocumentAlreadyExists;
import org.globant.restaurantalone.mapper.ClientMapper;
import org.globant.restaurantalone.service.Client.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    IClientService clientService;

    ClientMapper converter;

    @GetMapping("/{document}")
    public ResponseEntity<?> findClientByDocument(@PathVariable String document) throws ClientNotFound {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByDocument(document));
    }

    @PostMapping("")
    public ResponseEntity<?> saveClient(@RequestBody ClientDto client)
            throws ClientDocumentAlreadyExists, ClientDataInvalidOrIncomplete
    {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }

    @PutMapping("/{document}")
    public ResponseEntity<?> updateClient(@PathVariable String document, @RequestBody ClientDto clientdto){
            clientService.updateByDocument(clientdto);
            return ResponseEntity
                    .ok()
                    .body(clientService.findByDocument(document));
    }

    @DeleteMapping("/{document}")
    public ResponseEntity<?> deleteClient(@PathVariable String document){
        return clientService.deleteByDocument(document);
    }

}
