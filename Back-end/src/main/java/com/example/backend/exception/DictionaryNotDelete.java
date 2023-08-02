package com.example.backend.exception;

public class DictionaryNotDelete extends RuntimeException {

    public DictionaryNotDelete(int id) {
        super("thats not delete : "+id);
    }
}
