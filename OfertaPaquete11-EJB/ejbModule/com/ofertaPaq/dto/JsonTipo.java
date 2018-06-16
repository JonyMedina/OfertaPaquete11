package com.ofertaPaq.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JsonTipo implements Serializable {
	
	private long id;
	private String nombre;
	private List<JsonServicio> servicios = new ArrayList<JsonServicio>();

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<JsonServicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<JsonServicio> servicios) {
		this.servicios = servicios;
	}
	
	
	
	
	

	

}
