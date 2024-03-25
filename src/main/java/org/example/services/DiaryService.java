package org.example.services;

import org.example.data.models.Diary;
import org.example.data.models.Entry;
import org.example.dtos.requests.EntryRequest;
import org.example.dtos.requests.LoginRequest;
import org.example.dtos.requests.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiaryService {
    void registerUser(RegisterRequest registerRequest);
    boolean login(LoginRequest login);
    long getNumberOfUsers();
    Diary getUserDiary(String username);
    void logout(String username);
    boolean isLoggedIn();
    void createEntry(EntryRequest entryRequest);
    List<Entry> getEntriesFor(String username);
    void deleteEntry(int id);
    Entry findEntry(int id);
    List<Entry> findAllEntries();
    void updateEntry(EntryRequest entryUpdate);
    void deleteAccount(String username);
}
