package com.ofertaPaq.dto;

import java.io.Serializable;


public class UbicacionDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double Logitud;
	private Double Latitud;
	
	//ver si necesitamos mas datos de la ubicacion o con esto es suficiente

	public Double getLogitud() {
		return Logitud;
	}
	public void setLogitud(Double logitud) {
		Logitud = logitud;
	}
	public Double getLatitud() {
		return Latitud;
	}
	public void setLatitud(Double latitud) {
		Latitud = latitud;
	}
	
	
	
}
