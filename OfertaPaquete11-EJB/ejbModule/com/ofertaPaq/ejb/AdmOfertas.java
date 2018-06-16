package com.ofertaPaq.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ofertaPaq.dto.*;


import com.ofertaPaq.entities.*;



/**
 * Session Bean implementation class AdmOfertas
 */
@Stateless
@LocalBean
public class AdmOfertas implements AdmOfertasRemote {

	@PersistenceContext(unitName="MyPU")
	   private EntityManager manager;
	
    public AdmOfertas() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaPaquete(OfertaPaquete oferta){

       	
    	try{
    		manager.persist(oferta);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
    }
    
    @SuppressWarnings("unchecked")
 	public ArrayList<OfertaPaqueteDTO> recuperarPaquetes() {
		try {
			Query q = manager.createQuery("Select o from OfertaPaquete o");
			List<OfertaPaquete> oferta = (List<OfertaPaquete>) q.getResultList();
			ArrayList<OfertaPaqueteDTO> ofertasD = new ArrayList<OfertaPaqueteDTO>();

			for (OfertaPaquete o : oferta) {
				OfertaPaqueteDTO ofertaD = new OfertaPaqueteDTO();
				ofertaD.setCantidadPersonas(o.getCantidadPersonas());
				ofertaD.setCupo(o.getCupo());
				ofertaD.setDescripcion(o.getDescripcion());
				
				DestinoDTO destinoD = new DestinoDTO();
				destinoD.setNombre(o.getDestino().getNombre());
				
				UbicacionDTO ubicacionD = new UbicacionDTO();
				ubicacionD.setLatitud(o.getDestino().getUbicacion().getLatitud());
				ubicacionD.setLogitud(o.getDestino().getUbicacion().getLatitud());
				
				destinoD.setUbicacion(ubicacionD);
															
				ofertaD.setDestino(destinoD);
				
				ofertaD.setEstado(o.getEstado());
				ofertaD.setFechaRegreso(o.getFechaRegreso());
				ofertaD.setFechaSalida(o.getFechaSalida());
				

				ofertaD.setFoto(o.getFoto());
				
				
				
				ArrayList<MedioDePagoDTO> mediosD = new ArrayList<MedioDePagoDTO>();
				for(MedioDePago m: o.getMediosDePagos()){
					MedioDePagoDTO medioD = new MedioDePagoDTO();
					medioD.setNombre(m.getNombre());
					mediosD.add(medioD);
					
				}
				ofertaD.setMediosDePagos(mediosD);
				
				ofertaD.setNombre(o.getNombre());
				
				ofertaD.setPoliticaCancelacion(o.getPoliticaCancelacion());
				ofertaD.setPrecioXPersona(o.getPrecioXPersona());
				
				
				ArrayList<ServicioDTO> serviciosD = new ArrayList<ServicioDTO>();
				for(Servicio s: o.getServicios()){
					ServicioDTO servicioD = new ServicioDTO();
					servicioD.setDescripcion(s.getDescripcion());
					serviciosD.add(servicioD);
					
					
				}
				ofertaD.setServicios(serviciosD);
				ofertaD.setIdPaquete(o.getIdPaquete());
				
				ofertasD.add(ofertaD);
			}
			
			return ofertasD;
		} catch (Exception e) {
			e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
		}
		return null;
	}

	@Override
	public void altaMedios(MedioDePago mediosN) {
		try{
    		manager.persist(mediosN);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
		
	}

	@Override
	public void altaServicio(Servicio servicioN) {
		try{
    		manager.merge(servicioN);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
		
	}

	@Override
	public void altaDestino(Destino destinoN) {
		try{
    		manager.persist(destinoN);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
	}

	@SuppressWarnings("unchecked")
	public List<MedioDePagoDTO> recuperarMedios() {
		try {
			Query q = manager.createQuery("Select a from MedioDePago a");
			List<MedioDePago> medios = (List<MedioDePago>) q.getResultList();
			ArrayList<MedioDePagoDTO> mediosD = new ArrayList<MedioDePagoDTO>();

			for (MedioDePago m : medios) {
				MedioDePagoDTO medioD = new MedioDePagoDTO();
				medioD.setIdMP(m.getIdMP());
				medioD.setNombre(m.getNombre());
				mediosD.add(medioD);
			}
			
			return mediosD;
		} catch (Exception e) {
			e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
		}
		return null;
	}
	
	public MedioDePago recuperarMedio(int clave) {
		try {
				MedioDePago medio = manager.find(MedioDePago.class, clave);
				return medio;
			} catch (Exception e) {
				e.printStackTrace();
	    		System.out.println("Conectando a " + e.getMessage());
			}
			return null;
	}
	
	public Destino recuperarDestino(int clave) {
		try {
				Destino destino = manager.find(Destino.class, clave);
				return destino;
			} catch (Exception e) {
				e.printStackTrace();
	    		System.out.println("Conectando a " + e.getMessage());
			}
			return null;
	}
	
	public Servicio recuperarServicio(int clave) {
		try {
				Servicio servicio = manager.find(Servicio.class, clave);
				return servicio;
			} catch (Exception e) {
				e.printStackTrace();
	    		System.out.println("Conectando a " + e.getMessage());
			}
			return null;
	}
	

	@SuppressWarnings("unchecked")
	public List<ServicioDTO> recuperarServicios() {
		try {
			Query q = manager.createQuery("Select a from Servicio a");
			List<Servicio> servicios = (List<Servicio>) q.getResultList();
			ArrayList<ServicioDTO> serviciosD = new ArrayList<ServicioDTO>();

			for (Servicio s : servicios) {
				ServicioDTO servicioD = new ServicioDTO();
				servicioD.setDescripcion(s.getDescripcion());
				servicioD.setIdServicio(s.getIdServicio());
				
				
				serviciosD.add(servicioD);
			}
			
			return serviciosD;
		} catch (Exception e) {
			e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<DestinoDTO> recuperarDestinos() {
		try {
			Query q = manager.createQuery("Select a from Destino a");
			List<Destino> destinos = (List<Destino>) q.getResultList();
			ArrayList<DestinoDTO> destinosD = new ArrayList<DestinoDTO>();

			for (Destino d : destinos) {
				DestinoDTO destinoD = new DestinoDTO();
				destinoD.setIdDestino(d.getIdDestino());
				destinoD.setNombre(d.getNombre());
				UbicacionDTO ubi = new UbicacionDTO();
				ubi.setLatitud(d.getUbicacion().getLatitud());
				ubi.setLogitud(d.getUbicacion().getLogitud());
				
				destinoD.setUbicacion(ubi);
				
				
				destinosD.add(destinoD);
			}
			
			return destinosD;
		} catch (Exception e) {
			e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
		}
		return null;
	}


    

}
