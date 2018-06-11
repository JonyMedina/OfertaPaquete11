package com.ofertaPaq.integraciones;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.net.HttpURLConnection; import java.net.URL;
import org.apache.commons.io.IOUtils;


@Stateless
@LocalBean
public class ToBackOffice {

    public ToBackOffice() {
    }

    
    //los dos ejemplos de abajo fueron sacados del documento que subio el profe al share
    //metodo creado como ejemplo para llamada get a un resful service GET
    
    public void llamadaGetEjemplo() throws Exception{
    	URL url = new URL("http://localhost:8080/jax-rs-example/rest/service/hola");
    			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    			if(urlConnection.getResponseCode() != 200) {
    			throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
    			}
    			String response = IOUtils.toString(urlConnection.getInputStream()); System.out.println("Respuesta: " + response);
    }
    
    //metodo creado como ejemplo para llamada get a un resful service POST

    public void llamadaPostEjemplo() throws Exception {
    	
    	URL url = new URL("http://localhost:8080/jax-rs-example/rest/service/saludo"); 
    	HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); 
    	urlConnection.setDoOutput(true);
    	urlConnection.setRequestMethod("POST"); 
    	urlConnection.setRequestProperty("Content-Type", "text/plain"); 
    	IOUtils.write("Juanito", urlConnection.getOutputStream()); 
    	if(urlConnection.getResponseCode() != 200) {
    		throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
    	}
    	String response = IOUtils.toString(urlConnection.getInputStream()); System.out.println("Respuesta: " + response);
    }
    
}
