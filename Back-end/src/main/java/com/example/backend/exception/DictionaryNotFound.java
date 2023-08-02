package com.example.backend.exception;



public class DictionaryNotFound extends RuntimeException {

    public DictionaryNotFound(int id) {
        super("user not found: "+id);

    }

}

