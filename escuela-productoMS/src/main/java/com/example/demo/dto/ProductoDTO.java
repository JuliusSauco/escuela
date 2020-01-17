package com.example.demo.dto;

import java.math.BigDecimal;
import com.example.demo.entity.ImagenProducto;
import com.example.demo.entity.TipoProducto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {
	
	private String nombre;
	private String codigo;
	private String descripcion;
	private BigDecimal precio;
	private Boolean estado;
	
	//RELACIONES
	@JsonProperty(value = "tipo_producto")
	private TipoProducto tipoProducto;
	@JsonProperty(value = "img_producto")
	private ImagenProducto imagenProducto;
	
	//CANTIDAD
	private int cantidadStock;


}
