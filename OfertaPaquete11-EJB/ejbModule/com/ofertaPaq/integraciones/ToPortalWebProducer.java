package com.ofertaPaq.integraciones;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;


@Stateless
@LocalBean
public class ToPortalWebProducer implements ToPortalWebProducerRemote, ToPortalWebProducerLocal {

  
    public ToPortalWebProducer() {
  
    }
    
    @Resource(mappedName = "java:/queue/test")
    Queue testQueue;
    @Inject
    JMSContext jmsContext;

    public void enqueue(final String text) {
        jmsContext.createProducer().send(testQueue, text);
    }
    
    

}
