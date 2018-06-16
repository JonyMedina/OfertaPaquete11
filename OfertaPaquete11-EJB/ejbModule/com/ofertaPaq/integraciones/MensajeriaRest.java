package com.ofertaPaq.integraciones;


import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import com.ofertaPaq.dto.*;



import com.google.gson.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Stateless
@LocalBean
public class MensajeriaRest {


    public MensajeriaRest() {

    }
    
	public JsonAgencia envioAgenciaJSON(String agencia) throws IOException{
		URL url = new URL("http://192.168.1.92:8080/TPO_BO_WEB/rest/ServiciosBO/EnviarSolicitud");
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
	  	urlConnection.setRequestProperty("Content-Type","application/json");
	  	
	 // Send post request
	  	urlConnection.setDoOutput(true);
	 	DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
	 	wr.writeBytes(agencia);
	 	wr.flush();
	 	wr.close();

	 	int responseCode = urlConnection.getResponseCode();
	 	System.out.println("\nSending 'POST' request to URL : " + url);
	 	System.out.println("Post parameters : " + agencia);
	 	System.out.println("Response Code : " + responseCode);

	 	BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	 	String inputLine;
	 	StringBuffer response = new StringBuffer();

	 	while((inputLine = in.readLine()) != null) {
	 		response.append(inputLine);
	 	}
		in.close();

		//print result
 		//System.out.println(response.toString());
 		Gson gson = new Gson();
 		
 		JsonAgencia agencia2 = gson.fromJson(response.toString(), JsonAgencia.class);
 		System.out.println("Id: "+agencia2.getId());
 		return agencia2;
	}


	public void envioLog (String log) throws IOException{
		URL url = new URL("http://192.168.1.92:8080/TPO_BO_WEB/rest/ServiciosBO/RegistrarLog");
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
	  	urlConnection.setRequestProperty("Content-Type","application/json");
	  	
	 // Send post request
	  	urlConnection.setDoOutput(true);
	 	DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
	 	wr.writeBytes(log);
	 	wr.flush();
	 	wr.close();

	 	int responseCode = urlConnection.getResponseCode();
	 	System.out.println("\nSending 'POST' request to URL : " + url);
	 	System.out.println("Post parameters : " + log);
	 	System.out.println("Response Code : " + responseCode);

	 	BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	 	String inputLine;
	 	StringBuffer response = new StringBuffer();

	 	while((inputLine = in.readLine()) != null) {
	 		response.append(inputLine);
	 	}
		in.close();

		//print result
 		System.out.println(response.toString());

	}

	public List<JsonServicio> recuperarServicios(String tipo) throws IOException{

			URL url = new URL("http://192.168.1.92:8080/TPO_BO_WEB/rest/ServiciosBO/GetServiciosPorTipo");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
		  	urlConnection.setRequestProperty("Content-Type","application/json");
		  	
		 // Send post request
		  	urlConnection.setDoOutput(true);
		 	DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
		 	wr.writeBytes(tipo);
		 	wr.flush();
		 	wr.close();

		 	int responseCode = urlConnection.getResponseCode();
		 	System.out.println("\nSending 'POST' request to URL : " + url);
		 	System.out.println("Post parameters : " + tipo);
		 	System.out.println("Response Code : " + responseCode);

		 	BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		 	String inputLine;
		 	StringBuffer response = new StringBuffer();

		 	while((inputLine = in.readLine()) != null) {
		 		response.append(inputLine);
		 	}
			in.close();

			//print result
	 		System.out.println(response.toString());
	 		
	 		Gson gson = new Gson();
	 		JsonServicio[] servicios = gson.fromJson(response.toString(), JsonServicio[].class);
	 		
	 		return Arrays.asList(servicios);
	}
	
	
	
}
