package com.ofertaPaq.dto;


import java.io.Serializable;
import java.util.List;

public class JsonOferta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo_prestador;
	private String destino;
	private String fecha_desde;
	private String fecha_hasta;
	private int cantidad_personas_paquete;
	private String foto_paquete;
	private String descripcion_paquete;
	private List<String> servicios_paquete;
	private float precio;
	private Double latitud;
	private Double longitud;
	private String politica_cancelacion;
	private List<Integer> medio_pago_paquete;
	private String mail_agencia;
	private int cupo_paquete;
	public int getCodigo_prestador() {
		return codigo_prestador;
	}
	public void setCodigo_prestador(int codigo_prestador) {
		this.codigo_prestador = codigo_prestador;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(String fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public String getFecha_hasta() {
		return fecha_hasta;
	}
	public void setFecha_hasta(String fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	public int getCantidad_personas_paquetes() {
		return cantidad_personas_paquete;
	}
	public void setCantidad_personas_paquetes(int cantidad_personas_paquete) {
		this.cantidad_personas_paquete = cantidad_personas_paquete;
	}
	public String getFoto_paquete() {
		return foto_paquete;
	}
	public void setFoto_paquete(String foto_paquete) {
		this.foto_paquete = foto_paquete;
	}
	public String getDescripcion_paquete() {
		return descripcion_paquete;
	}
	public void setDescripcion_paquete(String descripcion_paquete) {
		this.descripcion_paquete = descripcion_paquete;
	}
	public List<String> getServicios_paquete() {
		return servicios_paquete;
	}
	public void setServicios_paquete(List<String> servicios_paquete) {
		this.servicios_paquete = servicios_paquete;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	public String getPolitica_cancelacion() {
		return politica_cancelacion;
	}
	public void setPolitica_cancelacion(String politica_cancelacion) {
		this.politica_cancelacion = politica_cancelacion;
	}
	public List<Integer> getMedio_pago_paquete() {
		return medio_pago_paquete;
	}
	public void setMedio_pago_paquete(List<Integer> medio_pago_paquete) {
		this.medio_pago_paquete = medio_pago_paquete;
	}
	public String getMail_agencia() {
		return mail_agencia;
	}
	public void setMail_agencia(String mail_agencia) {
		this.mail_agencia = mail_agencia;
	}
	public int getCupo_paquete() {
		return cupo_paquete;
	}
	public void setCupo_paquete(int cupo_paquete) {
		this.cupo_paquete = cupo_paquete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
