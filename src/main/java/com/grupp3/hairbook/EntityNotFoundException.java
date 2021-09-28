package com.grupp3.hairbook;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(long id) {
        super(String.format("Entity with id %d not found", id));
    }
}
