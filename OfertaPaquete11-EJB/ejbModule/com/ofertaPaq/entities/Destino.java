package com.ofertaPaq.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Destinos")
public class Destino implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdDestino;
	private String Nombre;
	@Embedded 
 	private Ubicacion Ubicacion;
 	
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
	public Ubicacion getUbicacion() {
		return Ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		Ubicacion = ubicacion;
	}
 	
 	
 	
}