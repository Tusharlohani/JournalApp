package com.learningviaprojects.journalApp.service;

import com.learningviaprojects.journalApp.JournalApplication;
import com.learningviaprojects.journalApp.entity.JournalEntry;
import com.learningviaprojects.journalApp.repository.JournalEntryRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Slf4j
@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journalEntry){
        try {
            journalEntry.setDate(LocalDateTime.now());
            journalEntryRepo.save(journalEntry);
        }catch(Exception e){
            log.error("Exception" + e);
        }

    }
    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }
    public Optional<JournalEntry> findAById(ObjectId id){
        return journalEntryRepo.findById(id);
    }
    public void deleteById(ObjectId id){
        journalEntryRepo.deleteById(id);
    }
}
