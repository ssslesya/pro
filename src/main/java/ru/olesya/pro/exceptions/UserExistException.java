package ru.olesya.pro.exceptions;

public class UserExistException extends RuntimeException{
    public UserExistException(String message) {
        super(message);
    }
}
