package com.elitech.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Note;


public interface NoteRepository extends JpaRepository<Note, Long> {
Page<Note> findByAuteur(String auteur,Pageable page);
Page<Note> findByTexteContaining(String texte,Pageable page);

}
