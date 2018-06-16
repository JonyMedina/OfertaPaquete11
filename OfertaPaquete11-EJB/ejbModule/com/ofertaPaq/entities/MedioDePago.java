package com.ofertaPaq.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MediosPagos")
public class MedioDePago implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8742023307663445124L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
