package com.elitech.services.implement;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.model.dto.DepartementDTO;
import com.elitech.model.entities.Departement;
import com.elitech.model.mapper.DepartementMapper;
import com.elitech.repository.DepartementRepository;
import com.elitech.services.DepartementService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class DepartementServiceImplement implements DepartementService {

	
	private final DepartementRepository departementRepository;
	@Override
	public DepartementDTO createOneDepartement(DepartementDTO departement, Pageable page) {
		// TODO Auto-generated method stub
		Departement depart=DepartementMapper.convertToEntity(departement);
		Departement savedDepart=departementRepository.save(depart);
		return DepartementMapper.convertToDTO(savedDepart);
	}

	@Override
	public Page<DepartementDTO> getAllDepartement(Pageable page) {
		// TODO Auto-generated method stub
		Page<Departement> deps=departementRepository.findAll(page);
		
		return deps.map(DepartementMapper::convertToDTO);
	}

	@Override
	public DepartementDTO getOneDepartement(long id) {
		// TODO Auto-generated method stub
		return departementRepository.findById(id).map(DepartementMapper::convertToDTO).orElse(null);
	}

	@Override
	public Page<DepartementDTO> getByNomOrDescription(String nom, String description, Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Departement> deps=departementRepository.findByNomOrDescription(nom, description, pageable);
		
		return deps.map(DepartementMapper::convertToDTO);
	}

	@Override
	public void deleteOneDepartement(long id) {
		// TODO Auto-generated method stub
		departementRepository.deleteById(id);
	}

}
