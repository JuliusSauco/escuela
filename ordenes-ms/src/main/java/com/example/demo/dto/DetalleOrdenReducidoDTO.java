package com.example.demo.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetalleOrdenReducidoDTO {
	
	private Long idProducto;
	private int cantidad;
	private BigDecimal precio;
}
