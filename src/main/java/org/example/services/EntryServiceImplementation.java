package org.example.services;

import org.example.data.models.Entry;
import org.example.data.repositories.EntryRepository;
import org.example.services.Exceptions.EntryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImplementation implements EntryService{
    @Autowired
    private EntryRepository repository;

    @Override
    public List<Entry> findEntriesByAuthor(String username) {
        return repository.findByAuthor(username);
    }

    @Override
    public void addEntry(Entry entry) {
        repository.save(entry);
    }

    @Override
    public Entry findEntry(int id) {
        Optional<Entry> foundEntry = repository.findById(String.valueOf(id));
        checkNullEntry(foundEntry);
        return foundEntry.get();
    }

    private void checkNullEntry(Optional<Entry> foundEntry) {
        if (foundEntry.isEmpty())throw new EntryNotFoundException("Entry does not exist");
    }

    @Override
    public void deleteEntry(int id) {
        Entry foundEntry = findEntry(id);
        repository.delete(foundEntry);
    }

    @Override
    public void updateEntry(Entry entry) {
        addEntry(entry);
    }

    @Override
    public List<Entry> findAll() {
        List<Entry> entries = repository.findAll();
        if (entries.isEmpty())throw new EntryNotFoundException("No Entries Currently Found!");
        return entries;
    }
}
