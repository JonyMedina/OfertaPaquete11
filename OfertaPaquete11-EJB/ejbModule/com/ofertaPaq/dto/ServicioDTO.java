package com.ofertaPaq.dto;


import java.io.Serializable;


public class ServicioDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer IdServicio;
	private String Descripcion;
	public Integer getIdServicio() {
		return IdServicio;
	}
	public void setIdServicio(Integer idServicio) {
		IdServicio = idServicio;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
	
	
	
}
