package com.learningviaprojects.journalApp.controller;

import ch.qos.logback.classic.joran.JoranConfigurator;
import com.learningviaprojects.journalApp.JournalApplication;
import com.learningviaprojects.journalApp.entity.JournalEntry;
import com.learningviaprojects.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping //http://localhost:8081/journal get req will come here
    public ResponseEntity<?> getAll(){//mapping methods should be public so that controller class can access it.
        List<JournalEntry> all=journalEntryService.getAll();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //If true: The method returns a ResponseEntity containing the list
        // of JournalEntry objects and an HTTP status code of 200 OK, meaning the request was successful and data is present.
    }
    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){  //http://localhost:8081/journal  post will come here
        try{
            journalEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("id/{myId}")//used to fetch any particular record with the help of myd and path variable
    public ResponseEntity<JournalEntry> getJournalById(@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry=journalEntryService.findAById(myId);
        if(journalEntry.isPresent()){//use this as lambda expression
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //LambdaExpression
//        return journalEntry.map(entry -> new ResponseEntity<>(entry, HttpStatus.OK)).orElseGet(() ->
//                new ResponseEntity<>(journalEntry.get(), HttpStatus.NOT_FOUND));


    }
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("id/{Id}")
    public ResponseEntity<?> updateJournalEntryById(@PathVariable ObjectId Id,@RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findAById(Id).orElse(null);
        if (old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
