package org.example.dtos.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    String username;
    String password;

    public void setUsername(String username){
        this.username = username.toLowerCase();
    }
}
