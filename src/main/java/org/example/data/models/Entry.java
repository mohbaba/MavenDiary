package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Entry {
    @Id
    private int id;
    private String title;
    private String body;
    private LocalDate creationDate = LocalDate.now();
    private String author;
}
