package org.abondar.experimental.jms2rest;


import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import java.net.ConnectException;

public class Jms2RestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://in").id("file2jms").to("jms:person");

        from("jms:person").id("personJms2Rest")
                .onException(ConnectException.class).log("Exception processing message").end()
                .choice()
                .when(header("CamelFileName")
                .endsWith(".xml"))
                .setHeader("person_id",xpath("/person/id").stringResult())
                .setHeader(Exchange.CONTENT_TYPE,constant("application/xml"))
                .endChoice()
                .when(header("CamelFileName")
                        .endsWith(".json"))
                .setHeader("person_id").jsonpath("$.person.id")
                .setHeader(Exchange.CONTENT_TYPE,constant("application/json"))
                .end()
                .to("log:test")
                .setHeader(Exchange.HTTP_METHOD,constant("PUT"))
                .setHeader(Exchange.HTTP_URI,simple("${properties:personServiceUri}/${headers.person_id}"))
                .to("http://dummy");
    }
}
