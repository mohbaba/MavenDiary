package org.example.services.Exceptions;

public class LoginRequiredException extends DiaryAppException{
    public LoginRequiredException(String message){
        super(message);
    }
}
