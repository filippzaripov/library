package com.fujitsu.internship.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataAccessException extends RuntimeException {
    Logger log = LoggerFactory.getLogger(DataAccessException.class);
    protected DataAccessException() {

    }

    public DataAccessException(String message, Exception exception) {
        super(message, exception);
    }
    public DataAccessException(String message){
        log.error(message);
    }
}
