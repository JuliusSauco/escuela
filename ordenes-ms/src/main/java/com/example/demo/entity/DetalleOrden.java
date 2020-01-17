package com.example.demo.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleOrden;
	
	@ManyToOne
	@Column
	private Orden orden;
	
	@NotBlank
	@NotNull
	@Column
	private Long idProducto;
	
	@NotBlank
	@NotNull
	@Column
	private int cantidad;
	
	@NotBlank
	@NotNull
	@Column
	private BigDecimal precio;
}
