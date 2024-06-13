package com.GG.Notate.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note {
    @Id
    @JsonProperty("_id")
    private String id;
    private String title;
    private String content;
    private String noteStatus;

    public Note() {
    }

    public Note(String title, String content, String noteStatus) {
        this.title = title;
        this.content = content;
        this.noteStatus = noteStatus;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getNoteStatus() {
        return noteStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNoteStatus(String noteStatus) {
        this.noteStatus = noteStatus;
    }
}
