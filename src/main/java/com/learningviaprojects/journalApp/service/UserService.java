package com.learningviaprojects.journalApp.service;

import com.learningviaprojects.journalApp.entity.JournalEntry;
import com.learningviaprojects.journalApp.entity.UserEntry;
import com.learningviaprojects.journalApp.repository.JournalEntryRepo;
import com.learningviaprojects.journalApp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void saveEntry(UserEntry userEntry){
        try {
            userRepo.save(userEntry);
        }catch(Exception e){
            log.error("Exception" + e);
        }

    }
    public List<UserEntry> getAll(){
        return userRepo.findAll();
    }
    public Optional<UserEntry> findAById(ObjectId id){
        return userRepo.findById(id);
    }
    public void deleteById(ObjectId id){
        userRepo.deleteById(id);
    }
}
