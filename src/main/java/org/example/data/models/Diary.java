package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.StringJoiner;

@Data
@Document
public class Diary {
    @Id
    private String username;
    private String password;
    private boolean isLocked;

    public void setUsername(String username){
        this.username = username.toLowerCase();
    }

}
