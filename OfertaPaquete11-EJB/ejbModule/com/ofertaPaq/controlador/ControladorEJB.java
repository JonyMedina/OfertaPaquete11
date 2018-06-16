package com.ofertaPaq.controlador;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ofertaPaq.integraciones.ToPortalWebProducer;


//
//
//  ESTA CLASE NO SE USA, SE USA EL OfertaPaqueteFacade
//


@Stateless
@LocalBean
public class ControladorEJB implements ControladorEJBRemote, ControladorEJBLocal {

    public ControladorEJB() {

    }

    
    //Este metodo esta solo como referencia para encolar los mensajes que van al portalWeb
    public void llamadaAlProducer(){
        final String text = "Hello, JMS!";
       new ToPortalWebProducer().enqueue(text);
    }
    
    
}
