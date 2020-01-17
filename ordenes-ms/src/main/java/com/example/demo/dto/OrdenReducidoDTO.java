package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdenReducidoDTO {

	private Long idCliente;
	private Date fecha;
	private BigDecimal total;
}
