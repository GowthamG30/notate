package com.GG.Notate.service;

import com.GG.Notate.model.Note;
import com.GG.Notate.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public Note getNoteById(String id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public Note updateNoteById(Note updatedNote) {
        return noteRepository.save(updatedNote);
    }

    public void deleteNoteById(String id) {
        noteRepository.deleteById(id);
    }
}
