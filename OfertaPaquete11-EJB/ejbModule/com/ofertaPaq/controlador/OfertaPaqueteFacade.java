package com.ofertaPaq.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import com.ofertaPaq.dto.*;
import com.ofertaPaq.ejb.*;
import com.ofertaPaq.integraciones.*;

import com.ofertaPaq.entities.*;

import com.google.gson.*;

@Stateless
public class OfertaPaqueteFacade implements OfertaPaqueteFacadeRemote {

	@EJB
	AdmAgenciasRemote admAgencia;
	@EJB
	AdmOfertasRemote admOfertas;
	
	@EJB
	OfertasProductor ofertaProductor;
	
	@EJB
	MensajeriaRest controladorRest;
	
	@Override
	public void altaAgencia(AgenciaDTO agencia) {
		Agencia agenciaN = new Agencia();
		JsonAgencia agenciaV;
		
		agenciaN.setDireccion(agencia.getDireccion());
		agenciaN.setEstado(agencia.getEstado());
		agenciaN.setId(agencia.getId());
		agenciaN.setMail(agencia.getMail());
		agenciaN.setNombre(agencia.getNombre());
		agenciaN.setIdBO(0);
		
		int id =admAgencia.altaAgencia(agenciaN);
		agenciaN.setId(id);
		

		Gson gson = new Gson();
	
		try {
			agenciaV=controladorRest.envioAgenciaJSON(gson.toJson(agencia.toJason()));
			agenciaN.setIdBO(agenciaV.getId());
			admAgencia.actualizarAgencia(agenciaN);
			
		  	JsonLog log = new JsonLog("BackOficce 1","Alta Agencia","OK");
		 	controladorRest.envioLog(gson.toJson(log));

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<AgenciaDTO> recuperarAgencias() {
		
		return admAgencia.recuperarAgencias();
		
	}

	@Override
	public void altaPaquete(OfertaPaqueteDTO oferta) {
		
		OfertaPaquete ofertaN = new OfertaPaquete();
		
		ofertaN.setCantidadPersonas(oferta.getCantidadPersonas());
		ofertaN.setCupo(oferta.getCupo());
		ofertaN.setDescripcion(oferta.getDescripcion());
		
		Destino destinoN = admOfertas.recuperarDestino(oferta.getDestino().getIdDestino());
		ofertaN.setDestino(destinoN);
		
		ofertaN.setEstado(oferta.getEstado());
		ofertaN.setFechaRegreso(oferta.getFechaRegreso());
		ofertaN.setFechaSalida(oferta.getFechaSalida());
		
	
		ofertaN.setFoto(oferta.getFoto());
		
		ofertaN.setIdPaquete(oferta.getIdPaquete());
	
		
	//  buscar medios de pago
		ArrayList<MedioDePago> medioPagoN = new ArrayList<MedioDePago>();
		for(MedioDePagoDTO m: oferta.getMediosDePagos()){
			MedioDePago mN = admOfertas.recuperarMedio(m.getIdMP());
			medioPagoN.add(mN);
		}
		
		ofertaN.setMediosDePagos(medioPagoN);
		ofertaN.setNombre(oferta.getNombre());
		ofertaN.setPoliticaCancelacion(oferta.getPoliticaCancelacion());
		ofertaN.setPrecioXPersona(oferta.getPrecioXPersona());
		
	//  buscar servicios
		ArrayList<Servicio> serviciosN = new ArrayList<Servicio>();
		for(ServicioDTO s: oferta.getServicios()){
			Servicio sN = admOfertas.recuperarServicio(s.getIdServicio());
			serviciosN.add(sN);
		}
		
		
		ofertaN.setServicios(serviciosN);
		
		Agencia agenciaN = admAgencia.recuperarAgencia(oferta.getAgencia().getId());
		
		ofertaN.setAgencia(agenciaN);
		
		
		admOfertas.altaPaquete(ofertaN);
		
 		Gson gson = new Gson();
  		ofertaProductor.sendMessage1(gson.toJson(ofertaN.toJson()));
 		ofertaProductor.sendMessage2(gson.toJson(ofertaN.toJson()));
 		
 		JsonLog log  = new JsonLog("Portal Web 4","Alta Agencia","OK");
 		JsonLog log2 = new JsonLog("Portal Web 7","Alta Agencia","OK");
		try {
			controladorRest.envioLog(gson.toJson(log));
			controladorRest.envioLog(gson.toJson(log2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

	@Override
	public ArrayList<OfertaPaqueteDTO> recuperarPaquetes() {
		return admOfertas.recuperarPaquetes();
	}

	@Override
	public void altaMedios(List<MedioDePagoDTO> medios) {
		for (MedioDePagoDTO m : medios){
			MedioDePago medioN = new MedioDePago();
			medioN.setNombre(m.getNombre());
			admOfertas.altaMedios(medioN);
		}
	}

	@Override
	public void altaServicios(List<ServicioDTO> servicios) {
		for (ServicioDTO s : servicios){
			Servicio servicioN = new Servicio();
			servicioN.setIdServicio(s.getIdServicio());
			servicioN.setDescripcion(s.getDescripcion());
			admOfertas.altaServicio(servicioN);
		}
	}

	@Override
	public void altaDestinos(List<DestinoDTO> destinos) {
		for (DestinoDTO d : destinos){
			Destino destinoN = new Destino();
			destinoN.setNombre(d.getNombre());
			Ubicacion ubicacionN = new Ubicacion();
			ubicacionN.setLatitud(d.getUbicacion().getLatitud());
			ubicacionN.setLogitud(d.getUbicacion().getLogitud());
			destinoN.setUbicacion(ubicacionN);
			admOfertas.altaDestino(destinoN);
		}
		
	}

	@Override
	public List<MedioDePagoDTO> recuperarMedios() {
		return admOfertas.recuperarMedios();
	}

	@Override
	public List<ServicioDTO> recuperarServicios() {
		
		JsonTipoServ tipo = new JsonTipoServ();
		tipo.setNombre("Paquete");
		
		Gson gson = new Gson();
		try {
	 		List<JsonServicio> servicio= (List<JsonServicio>) controladorRest.recuperarServicios(gson.toJson(tipo));
					
/*			List<JsonServicio> servicio = new ArrayList<JsonServicio>();
			JsonServicio js1 = new JsonServicio();
			js1.setId(1);
			js1.setNombre("serv1");
			servicio.add(js1);
			
			JsonServicio js2 = new JsonServicio();
			js2.setId(2);
			js2.setNombre("serv2");
			servicio.add(js2);*/
			
			
			List<ServicioDTO> servicios = new ArrayList<ServicioDTO>();
			
			for (JsonServicio serv :servicio){
				ServicioDTO sDto = new ServicioDTO();
				
				sDto.setIdServicio((int) serv.getId());
				sDto.setDescripcion(serv.getNombre());
				servicios.add(sDto);
			}
			
			this.altaServicios(servicios);
			
		  	JsonLog log = new JsonLog("BackOficce 1","Recuperar Servicios","OK");
		 	controladorRest.envioLog(gson.toJson(log));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return admOfertas.recuperarServicios();
	}

	@Override
	public List<DestinoDTO> recuperarDestinos() {
		return admOfertas.recuperarDestinos();
	}
     
}
