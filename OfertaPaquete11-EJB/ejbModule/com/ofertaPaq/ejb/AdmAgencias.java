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
 * Session Bean implementation class AdmAgencias
 */
@Stateless
@LocalBean
public class AdmAgencias implements AdmAgenciasRemote {

	@PersistenceContext(unitName="MyPU")
	   private EntityManager manager;
	
	
    public AdmAgencias() {
        // TODO Auto-generated constructor stub
    }

    public int altaAgencia(Agencia agencia){
    	try{
    		manager.persist(agencia);
    		return agencia.getId();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
		return 0;
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<AgenciaDTO> recuperarAgencias() {
		try {
			Query q = manager.createQuery("Select a from Agencia a");
			List<Agencia> agencia = (List<Agencia>) q.getResultList();
			ArrayList<AgenciaDTO> agencias = new ArrayList<AgenciaDTO>();

			for (Agencia a : agencia) {
				AgenciaDTO agenciaD = new AgenciaDTO();
				agenciaD.setDireccion(a.getDireccion());
				agenciaD.setEstado(a.getEstado());
				agenciaD.setId(a.getId());
				agenciaD.setMail(a.getMail());
				agenciaD.setNombre(a.getNombre());
				agencias.add(agenciaD);
			}
			
			return agencias;
		} catch (Exception e) {
			e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
		}
		return null;
	}
    
	public Agencia recuperarAgencia(int clave) {
		try {
				Agencia agencia = manager.find(Agencia.class, clave);
				return agencia;
			} catch (Exception e) {
				e.printStackTrace();
	    		System.out.println("Conectando a " + e.getMessage());
			}
			return null;
	}

	@Override
	public void actualizarAgencia(Agencia agencia) {
	 	try{
    		manager.merge(agencia);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
		// TODO Auto-generated method stub
		
	}
    
}
