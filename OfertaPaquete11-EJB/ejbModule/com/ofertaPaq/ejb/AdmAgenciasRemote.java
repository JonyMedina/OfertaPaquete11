package com.ofertaPaq.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.ofertaPaq.dto.*;
import com.ofertaPaq.entities.*;

@Remote
public interface AdmAgenciasRemote {
	
	public int altaAgencia(Agencia agencia);
	public ArrayList<AgenciaDTO> recuperarAgencias();
	public Agencia recuperarAgencia(int clave);
	public void actualizarAgencia(Agencia agenciaN);
}
