package com.example.demo.dto;

import java.math.BigDecimal;
import com.example.demo.entity.Orden;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetalleOrdenDTO {
	
	private Orden orden;
	private Long idProducto;
	private int cantidad;
	private BigDecimal precio;
	
}

