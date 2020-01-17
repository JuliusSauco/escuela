package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.FutureOrPresent;
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
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrden;
	
	@NotBlank
	@NotNull
	@Column
	private Long idCliente;
	
	@NotBlank
	@NotNull
	@Column
	private Date fecha;
	
	@NotBlank
	@NotNull
	@FutureOrPresent
	@Column
	private Date fechaEnvio;
	
	@OneToMany
	@Column
	private List<DetalleOrden> detalleOrdenes;
	
	@NotBlank
	@NotNull
	@Column
	private BigDecimal total;
}
