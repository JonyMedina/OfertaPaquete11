package com.ofertaPaq.dto;


import java.io.Serializable;


public class DestinoDTO implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer IdDestino;
	private String Nombre;
	
	
 	private UbicacionDTO Ubicacion;
 	
	public Integer getIdDestino() {
		return IdDestino;
	}
	public void setIdDestino(Integer idDestino) {
		IdDestino = idDestino;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public UbicacionDTO getUbicacion() {
		return Ubicacion;
	}
	public void setUbicacion(UbicacionDTO ubicacion) {
		Ubicacion = ubicacion;
	}
 	
 	
 	
}
