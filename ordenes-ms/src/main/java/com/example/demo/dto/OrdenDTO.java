package com.example.demo.dto;

import java.util.Date;
import java.util.List;
import com.example.demo.entity.DetalleOrden;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdenDTO {

	private Long idCliente;
	private Date fechaEnvio;
	private List<DetalleOrden> detalleOrdenes;

}
