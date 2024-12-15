package com.elitech.model.mapper;

import org.modelmapper.ModelMapper;

import com.elitech.model.dto.NoteDTO;
import com.elitech.model.entities.Note;

public class NoteMapper {
	private static final ModelMapper modelMapper=new ModelMapper();
	public static NoteDTO convertToDTO(Note note)
	{
		return modelMapper.map(note, NoteDTO.class);
	}
	public static Note convertToEntity(NoteDTO noteDto)
	{
		return modelMapper.map(noteDto, Note.class);
		
	}
}
