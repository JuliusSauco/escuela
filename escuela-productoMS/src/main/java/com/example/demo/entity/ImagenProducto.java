package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ImagenProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImagenProducto;
	
	@Column
	private String rutaThumbnail;
	
	@Column
	private String rutaImagen;

}
