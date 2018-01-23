package com.fujitsu.internship.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookValidationException extends RuntimeException {
    Logger logger = LoggerFactory.getLogger(BookValidationException.class);
    BookValidationException(String message, Exception exception){
        logger.error(message);
    }
}
