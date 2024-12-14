package com.elitech.model.entities;

import java.util.List;

import com.elitech.model.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departement extends BaseEntity {
	@Column(unique = true,nullable = false)
private String nom;

private String description;
@OneToMany(mappedBy = "departement")
private List<Note> notes;
}
