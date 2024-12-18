package com.elitech.controller;

import com.elitech.model.dto.NoteDTO;
import com.elitech.services.NoteService;
import com.elitech.services.implement.NoteServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteServiceImplement noteService;

    @GetMapping("/notes")
    public ResponseEntity<Page<NoteDTO>> getAllNotes(Pageable pageable) {
        return ResponseEntity.ok(noteService.getAllNotes(pageable));
    }

    @GetMapping("/auteur")
    public ResponseEntity<Page<NoteDTO>> getNoteByAuteur(@RequestParam String auteur, Pageable pageable) {
        return ResponseEntity.ok(noteService.getByAuteur(auteur, pageable));
    }

    @GetMapping("/text")
    public ResponseEntity<Page<NoteDTO>> getNoteByText(@RequestParam String text, Pageable pageable) {
        return ResponseEntity.ok(noteService.getByTexteContent(text, pageable));
    }

    @PostMapping("/add")
    public ResponseEntity<NoteDTO> addNote(@RequestBody NoteDTO noteDTO, @RequestParam long departemetId) {
        return ResponseEntity.ok(noteService.createOneNote(noteDTO, departemetId));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable long id) {
        noteService.deleteOneNote(id);
    }

    @PutMapping("/update{noteId},{departementId}")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable long noteId, @PathVariable long departementId, @RequestBody NoteDTO noteDTO) {
        if (noteService.getOneNote(noteId) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(noteService.createOneNote(noteDTO, departementId));
    }
}
