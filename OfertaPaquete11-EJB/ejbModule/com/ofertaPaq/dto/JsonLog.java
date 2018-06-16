package com.ofertaPaq.dto;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

public class JsonLog implements Serializable {
	
	private String plataformaEnvia;
	private String plataformaRecibe;
	private String servicio;
	private String observacion;
	
	public JsonLog(String plataformaRecibe, String servicio,
			String observacion) {
		super();
		this.plataformaEnvia= "Oferta Paquete 3";
		this.plataformaEnvia = plataformaEnvia;
		this.plataformaRecibe = plataformaRecibe;

//		Calendar calendar = Calendar.getInstance();
///		java.util.Date now = calendar.getTime();
//		this.fecha= new java.sql.Timestamp(now.getTime());
		
		this.servicio = servicio;
		this.observacion = observacion;
	}
	public String getPlataformaEnvia() {
		return plataformaEnvia;
	}
	public void setPlataformaEnvia(String plataformaEnvia) {
		this.plataformaEnvia = plataformaEnvia;
	}
	public String getPlataformaRecibe() {
		return plataformaRecibe;
	}
	public void setPlataformaRecibe(String plataformaRecibe) {
		this.plataformaRecibe = plataformaRecibe;
	}

	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	

}
