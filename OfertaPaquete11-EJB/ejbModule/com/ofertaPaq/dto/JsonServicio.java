package com.ofertaPaq.dto;


import java.io.Serializable;

public class JsonServicio implements Serializable {
	
	private long id;
	private JsonTipo tipo;
	private String nombre;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public JsonTipo getTipo() {
		return tipo;
	}
	public void setTipo(JsonTipo tipo) {
		this.tipo = tipo;
	}
	
	
	

	
	
	
	

}
