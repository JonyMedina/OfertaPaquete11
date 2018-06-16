package com.ofertaPaq.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class OfertaPaqueteDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer IdPaquete;
	private String Nombre;
	private DestinoDTO Destino;
	private Date FechaSalida;
	private Date FechaRegreso;
	private Float PrecioXPersona;
	private String PoliticaCancelacion;
  	private String Foto;
	private String Descripcion;
	private List<ServicioDTO> Servicios;
	private List<MedioDePagoDTO> MediosDePagos;
	private String Estado;
	private Integer Cupo;
	private Integer CantidadPersonas;
	private AgenciaDTO agencia;
	
	public Integer getIdPaquete() {
		return IdPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		IdPaquete = idPaquete;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public DestinoDTO getDestino() {
		return Destino;
	}
	public void setDestino(DestinoDTO destino) {
		Destino = destino;
	}
	public Date getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		FechaSalida = fechaSalida;
	}
	public Date getFechaRegreso() {
		return FechaRegreso;
	}
	public void setFechaRegreso(Date fechaRegreso) {
		FechaRegreso = fechaRegreso;
	}
	public Float getPrecioXPersona() {
		return PrecioXPersona;
	}
	public void setPrecioXPersona(Float precioXPersona) {
		PrecioXPersona = precioXPersona;
	}
	public String getPoliticaCancelacion() {
		return PoliticaCancelacion;
	}
	public void setPoliticaCancelacion(String politicaCancelacion) {
		PoliticaCancelacion = politicaCancelacion;
	}
 
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
 	public List<ServicioDTO> getServicios() {
 		return Servicios;
 	}
 	public void setServicios(List<ServicioDTO> servicios) {
 		Servicios = servicios;
 	}
	public List<MedioDePagoDTO> getMediosDePagos() {
		return MediosDePagos;
	}
	public void setMediosDePagos(List<MedioDePagoDTO> mediosDePagos) {
		MediosDePagos = mediosDePagos;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Integer getCupo() {
		return Cupo;
	}
	public void setCupo(Integer cupo) {
		Cupo = cupo;
	}
	public Integer getCantidadPersonas() {
		return CantidadPersonas;
	}
	public void setCantidadPersonas(Integer cantidadPersonas) {
		CantidadPersonas = cantidadPersonas;
	}
	public String getFoto() {
		return Foto;
	}
	public void setFoto(String foto) {
		Foto = foto;
	}
	public AgenciaDTO getAgencia() {
		return agencia;
	}
	public void setAgencia(AgenciaDTO agencia) {
		this.agencia = agencia;
	}
	

	
}
