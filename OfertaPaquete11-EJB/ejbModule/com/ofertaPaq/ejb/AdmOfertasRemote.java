package com.ofertaPaq.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import com.ofertaPaq.dto.*;
import com.ofertaPaq.entities.*;


@Remote
public interface AdmOfertasRemote {
	
	public void altaPaquete(OfertaPaquete oferta);
	public ArrayList<OfertaPaqueteDTO> recuperarPaquetes();
	public void altaMedios(MedioDePago mediosN);
	public void altaServicio(Servicio servicioN);
	public void altaDestino(Destino destinoN);
	public List<MedioDePagoDTO> recuperarMedios();
	public List<ServicioDTO> recuperarServicios();
	public List<DestinoDTO> recuperarDestinos();
	public MedioDePago recuperarMedio(int clave); 
	public Destino recuperarDestino(int clave); 
	public Servicio recuperarServicio(int clave); 
	


}
