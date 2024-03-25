package org.example.dtos.requests;

import lombok.Data;

@Data
public class EntryRequest {
    private int id;
    private String title;
    private String body;
    private String author;
}
