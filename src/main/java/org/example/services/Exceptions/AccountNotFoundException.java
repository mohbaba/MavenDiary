package org.example.services.Exceptions;

public class AccountNotFoundException extends DiaryAppException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
