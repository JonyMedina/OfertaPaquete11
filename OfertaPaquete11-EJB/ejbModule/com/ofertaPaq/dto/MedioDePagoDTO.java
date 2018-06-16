package com.ofertaPaq.dto;

import java.io.Serializable;


public class MedioDePagoDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer IdMP;
	private String Nombre;
	public Integer getIdMP() {
		return IdMP;
	}
	public void setIdMP(Integer idMP) {
		IdMP = idMP;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	
}
