package com.GG.Notate.controller;

import com.GG.Notate.model.Note;
import com.GG.Notate.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Note addedNote = noteService.addNote(note);
        return new ResponseEntity<>(addedNote, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable String id, @RequestBody Note updatedNote) {
        Note existingNote = noteService.getNoteById(id);
        if(existingNote != null) {
            updatedNote.setId(id);
            updatedNote.setNoteStatus(existingNote.getNoteStatus());
            Note savedNote = noteService.updateNoteById(updatedNote);
            return new ResponseEntity<>(savedNote, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<Note> updateNoteStatus(@PathVariable String id, @RequestBody Note updatedNote) {
        Note existingNote = noteService.getNoteById(id);
        if(existingNote != null) {
            updatedNote.setId(id);
            updatedNote.setTitle(existingNote.getTitle());
            updatedNote.setContent(existingNote.getContent());
            Note savedNote = noteService.updateNoteById(updatedNote);
            return new ResponseEntity<>(savedNote, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable String id) {
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
