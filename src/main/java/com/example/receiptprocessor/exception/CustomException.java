package com.example.receiptprocessor.exception;

public class CustomException extends NullPointerException{
    public CustomException(String message){
        super(message);
    }
}
