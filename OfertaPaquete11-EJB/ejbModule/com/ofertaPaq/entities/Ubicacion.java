package com.ofertaPaq.entities;


import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Ubicacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3188318212729404822L;
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
