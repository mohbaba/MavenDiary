package org.example.controllers;
import org.example.dtos.requests.EntryRequest;
import org.example.dtos.requests.LoginRequest;
import org.example.dtos.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.services.DiaryService;
import org.example.services.Exceptions.DiaryAppException;

@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest){
        try {
            diaryService.registerUser(registerRequest);
            return "Registration Successful!";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestBody String username) {
        try {
            diaryService.deleteAccount(username);
            return String.format("%s deleted successfully",username);
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @PostMapping("/write-entry")
    public String createEntry(@RequestBody EntryRequest entryRequest) {
        try {
            diaryService.createEntry(entryRequest);
            return "Entry created successfully";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @PostMapping("/delete-an-entry")
    public String deleteEntry(@RequestBody int id){
        try {
            diaryService.deleteEntry(id);
            return "Entry deleted successfully";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @GetMapping("/view-entry/{id}")
    public String findEntry(@PathVariable int id){
        try {
            diaryService.findEntry(id);
            return "Found Entry";
        }catch (DiaryAppException e ){
            return e.getMessage();
        }
    }

    @GetMapping("/all-entries-by-/{username}")
    public String findAllEntriesBy(@PathVariable String username){
        try {
            diaryService.getEntriesFor(username);
            return String.format("%s entries ",username);
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @PostMapping("/update-an-entry")
    public String updateEntry(@RequestBody EntryRequest entryRequest){
        try {
            diaryService.updateEntry(entryRequest);
            return "Entry successfully updated";
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @PostMapping("/delete-Account")
    public String deleteAccount(@RequestBody String username){
        try {
            diaryService.deleteAccount(username);
            return String.format("%s deleted successfully",username);
        }catch (DiaryAppException e){
            return  e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        try {
            diaryService.login(loginRequest);
            return String.format("%s successfully logged in",loginRequest.getUsername());
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @PostMapping("/logout")
    public String logout(@RequestBody String username){
        try {
            diaryService.logout(username);
            return String.format("%s successfully logged out ",username);
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

    @GetMapping("/diary/{username}")
    public String getUserDiary(@PathVariable String username){
        try {
            diaryService.getUserDiary(username);
            return String.format("%s's diary successfully found",username);
        }catch (DiaryAppException e){
            return e.getMessage();
        }
    }

}
