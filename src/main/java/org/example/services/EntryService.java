package org.example.services;

import org.example.data.models.Entry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntryService {
    List<Entry> findEntriesByAuthor(String username );
    void addEntry(Entry entry);
    Entry findEntry(int id);
    void deleteEntry(int id);
    void updateEntry(Entry entry);

    List<Entry> findAll();
}
