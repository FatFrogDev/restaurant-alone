package org.globant.restaurantalone.exceptions.Client;

public class ClientAlreadyExistException extends Error{
    public ClientAlreadyExistException(String message){
        super(message);
    };
}
