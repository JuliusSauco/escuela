package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_compania;
	@Column
	private String nombre;
	@Column
	private String RUC;
	@Column
	private String RazonSocial;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<Personas> personas;
	
}
