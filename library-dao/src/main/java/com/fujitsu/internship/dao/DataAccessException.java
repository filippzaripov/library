package com.fujitsu.internship.dao;


public class DataAccessException extends RuntimeException {
    protected DataAccessException() {

    }

    public DataAccessException(String message, Exception exception) {
        super(message, exception);
    }
}
