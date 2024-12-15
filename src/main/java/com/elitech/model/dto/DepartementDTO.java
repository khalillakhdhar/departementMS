package com.elitech.model.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartementDTO extends BaseDTO {
	@NotBlank(message = "le nom du département est obligatoire")
	@Size(min = 3, message = "la taille du nom de département est minimum 3 caractére")
	private String nom;
	@Size(min = 10,max = 100,message = "la taille de votre description doit être entre 10-100 caractére")
	private String description;
	private List<NoteDTO> notes;
}
