package com.ofertaPaq.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AgenciaEJB
 */
@Stateless
@LocalBean
public class AgenciaEJB implements AgenciaEJBRemote, AgenciaEJBLocal {

    /**
     * Default constructor. 
     */
    public AgenciaEJB() {
        // TODO Auto-generated constructor stub
    }

}
