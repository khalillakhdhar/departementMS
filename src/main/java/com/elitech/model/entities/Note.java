package com.elitech.model.entities;

import com.elitech.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Note extends BaseEntity {
private String texte;
private String auteur;
@ManyToOne(optional = false)
@JsonIgnore
private Departement departement;
}
