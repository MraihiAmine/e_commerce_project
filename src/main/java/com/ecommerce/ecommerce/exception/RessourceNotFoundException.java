package com.ecommerce.ecommerce.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    public RessourceNotFoundException(String e){
        super(e);
    }
}
