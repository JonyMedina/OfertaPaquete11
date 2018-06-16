package com.ofertaPaq.integraciones;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;


@Stateless
@LocalBean
public class OfertasProductor {


	public void sendMessage1(String messageText) {

	
	Context context;
	try {
	    final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "http-remoting://192.168.1.81:8080"));
        env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "paquete"));
        env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "paquete"));
        context = new InitialContext(env);

        // Perform the JNDI lookups
        String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);

        String destinationString = System.getProperty("destination", "jms/queue/ofertapaquete");
        Destination destination = (Destination) context.lookup(destinationString);

        // Create the JMS connection, session, producer, and consumer
        Connection connection = connectionFactory.createConnection(System.getProperty("username", "paquete"), System.getProperty("password", "paquete"));
        Session session = ((javax.jms.Connection) connection).createSession(false, Session.AUTO_ACKNOWLEDGE);
       // consumer = session.createConsumer(destination);
        connection.start();
		// crear un producer para enviar mensajes usando la session
		MessageProducer producer = session.createProducer((Destination) destination);
		// crear un mensaje de tipo text y setearle el contenido
		TextMessage message = session.createTextMessage();
		message.setText(messageText);
		// enviar el mensaje
		producer.send(message);
		// TODO: recordar cerrar la session y la connection en un bloque “finally”
		connection.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Mensaje enviado 1");
	}
	}
	
	
	public void sendMessage2(String messageText) {

		
		Context context;
		try {
		    final Properties env = new Properties();
	        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
	        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "http-remoting://192.168.1.69:8080"));
	        env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "paquete"));
	        env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "paquete"));
	        context = new InitialContext(env);

	        // Perform the JNDI lookups
	        String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
	        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);

	        String destinationString = System.getProperty("destination", "jms/queue/ofertapaquete");
	        Destination destination = (Destination) context.lookup(destinationString);

	        // Create the JMS connection, session, producer, and consumer
	        Connection connection = connectionFactory.createConnection(System.getProperty("username", "paquete"), System.getProperty("password", "paquete"));
	        Session session = ((javax.jms.Connection) connection).createSession(false, Session.AUTO_ACKNOWLEDGE);
	       // consumer = session.createConsumer(destination);
	        connection.start();
			// crear un producer para enviar mensajes usando la session
			MessageProducer producer = session.createProducer((Destination) destination);
			// crear un mensaje de tipo text y setearle el contenido
			TextMessage message = session.createTextMessage();
			message.setText(messageText);
			// enviar el mensaje
			producer.send(message);
			// TODO: recordar cerrar la session y la connection en un bloque “finally”
			connection.close();
		} catch (Exception e) {
			System.out.println("Mensaje enviado 2");
		}
		}
	
	

}
