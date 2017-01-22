package com.validation;

/**
 * Created by aleksei on 21.01.17.
 */
public class EmailExistsException extends Throwable{
    public EmailExistsException(String message) {
        super(message);
    }
}
