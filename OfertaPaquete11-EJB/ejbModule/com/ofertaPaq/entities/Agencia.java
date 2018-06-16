package com.ofertaPaq.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Agencias")
public class Agencia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1884450858434540761L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String Nombre;
	private String Direccion;
	private String Estado;
	private String Mail;

	@OneToMany
	@JoinColumn(name="agencia")
	private List<OfertaPaquete> Ofertas;
	
	private Integer IdBO;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
 	public List<OfertaPaquete> getOfertas() {
 		return Ofertas;
 	}
 	public void setOfertas(List<OfertaPaquete> ofertas) {
 		Ofertas = ofertas;
 	}
	public Integer getIdBO() {
		return IdBO;
	}
	public void setIdBO(Integer idBO) {
		IdBO = idBO;
	}
	
	
}