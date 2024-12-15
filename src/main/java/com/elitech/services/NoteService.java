package com.elitech.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.elitech.model.dto.NoteDTO;

public interface NoteService {
public NoteDTO createOneNote(NoteDTO note,long departementId);
public Page<NoteDTO> getAllNotes(Pageable page);
public Page<NoteDTO> getByAuteur(String auteur,Pageable page);
public Page<NoteDTO> getByTexteContent(String texte,Pageable page);
public void deleteOneNote(long id);
public NoteDTO getOneNote(long id);


}
