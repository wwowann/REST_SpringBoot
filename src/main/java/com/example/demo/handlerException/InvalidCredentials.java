package com.example.demo.handlerException;

public class InvalidCredentials extends NullPointerException{
    public InvalidCredentials(String message) {
        super(message);
    }
}
