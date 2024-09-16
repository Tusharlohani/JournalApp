/*
package com.learningviaprojects.journalApp.controller;

import ch.qos.logback.classic.joran.JoranConfigurator;
import com.learningviaprojects.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries=new HashMap<>();

    @GetMapping //http://localhost:8081/journal get req will come here
    public List<JournalEntry> getAll(){//mapping methods should be public so that controller class can access it.
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public Boolean createEntry(@RequestBody JournalEntry myEntry){  //http://localhost:8081/journal  post will come here
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }
    @GetMapping("id/{myId}")//used to fetch any particular record with the help of myd and path variable
    public JournalEntry getJournalById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{Id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long Id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(Id,myEntry);
    }
}
*/
