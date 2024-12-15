package com.elitech.model.mapper;

import org.modelmapper.ModelMapper;

import com.elitech.model.dto.DepartementDTO;
import com.elitech.model.entities.Departement;



public class DepartementMapper {
	private static final ModelMapper modelMapper=new ModelMapper();
	public static DepartementDTO convertToDTO(Departement departement)
	{
		return modelMapper.map(departement, DepartementDTO.class);
	}
	public static Departement convertToEntity(DepartementDTO departementDto)
	{
		return modelMapper.map(departementDto, Departement.class);
		
	}
}
