package com.elitech.services.implement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.model.dto.NoteDTO;
import com.elitech.model.entities.Departement;
import com.elitech.model.entities.Note;
import com.elitech.model.mapper.DepartementMapper;
import com.elitech.model.mapper.NoteMapper;
import com.elitech.repository.DepartementRepository;
import com.elitech.repository.NoteRepository;
import com.elitech.services.NoteService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class NoteServiceImplement  implements NoteService{
	private final DepartementRepository departementRepository;
	private final NoteRepository noteRepository;
	@Override
	public NoteDTO createOneNote(NoteDTO note, long departementId) {
		// TODO Auto-generated method stub
		Departement dep=departementRepository.findById(departementId).orElse(null);
		if(dep!=null)
		{
			note.setDepartement(DepartementMapper.convertToDTO(dep));
		}
		Note savedNote=noteRepository.save(NoteMapper.convertToEntity(note));

		return NoteMapper.convertToDTO(savedNote);
	}

	@Override
	public Page<NoteDTO> getAllNotes(Pageable page) {
		// TODO Auto-generated method stub
		
		return noteRepository.findAll(page).map(NoteMapper::convertToDTO);
	}

	@Override
	public Page<NoteDTO> getByAuteur(String auteur, Pageable page) {
		// TODO Auto-generated method stub
		return noteRepository.findByAuteur(auteur, page).map(NoteMapper::convertToDTO);
	}

	@Override
	public Page<NoteDTO> getByTexteContent(String texte,Pageable page) {
		// TODO Auto-generated method stub
		return noteRepository.findByTexteContaining(texte,page).map(NoteMapper::convertToDTO);
	}

	@Override
	public void deleteOneNote(long id) {
		// TODO Auto-generated method stub
		noteRepository.deleteById(id);
	}

	@Override
	public NoteDTO getOneNote(long id) {
		// TODO Auto-generated method stub
		return noteRepository.findById(id).map(NoteMapper::convertToDTO).orElse(null);
	}

}
