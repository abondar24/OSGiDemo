package org.abondar.experimental.order;


import org.apache.camel.CamelContext;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Starter {

    public void run() throws Exception{
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addComponent("properties", new PropertiesComponent("config.properties"));
        camelContext.start();
        System.in.read();
        camelContext.stop();
    }

    public static void main(String[] args) throws Exception {
        new Starter().run();
    }
}
