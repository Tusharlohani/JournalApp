package com.learningviaprojects.journalApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Getter
@Setter
@Data
@Document(collection = "users")
public class UserEntry {
    @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    @Id
    private ObjectId id;
    @DBRef
    private ArrayList<JournalEntry> journalEntries=new ArrayList<>();

}
