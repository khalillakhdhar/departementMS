package com.elitech.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.model.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
Page<Departement> findByNomOrDescription(String nom,String description,Pageable page);

}
