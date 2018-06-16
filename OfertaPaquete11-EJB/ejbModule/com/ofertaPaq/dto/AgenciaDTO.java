package com.ofertaPaq.dto;


import java.io.Serializable;
import java.util.List;

public class AgenciaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String Nombre;
	private String Direccion;
	private String Estado;
	private String Mail;
	private List<OfertaPaqueteDTO> Ofertas;
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
 	public List<OfertaPaqueteDTO> getOfertas() {
 		return Ofertas;
 	}
 	public void setOfertas(List<OfertaPaqueteDTO> ofertas) {
 		Ofertas = ofertas;
 	}
 	
 	public JsonAgencia toJason(){
 		JsonAgencia mensaje = new JsonAgencia("Agencia",Nombre, -1);
 		return mensaje;
 				
 	}
	public Integer getIdBO() {
		return IdBO;
	}
	public void setIdBO(Integer idBO) {
		IdBO = idBO;
	}
 	
 	
 	
	
}