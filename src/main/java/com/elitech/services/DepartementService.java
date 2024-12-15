package com.elitech.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elitech.model.dto.DepartementDTO;

public interface DepartementService {
public DepartementDTO createOneDepartement(DepartementDTO departement, Pageable page);
public Page<DepartementDTO> getAllDepartement(Pageable page);
public DepartementDTO getOneDepartement(long id);
public Page<DepartementDTO> getByNomOrDescription(String nom,String description, Pageable pageable);
public void deleteOneDepartement(long id);
}
