package com.ofertaPaq.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Servicios")
public class Servicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5904326681859091033L;
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
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

