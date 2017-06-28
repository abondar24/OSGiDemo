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
                .setHeader("person_id",xpath("/person/id").stringResult())
                .to("log:test")
                .setHeader(Exchange.HTTP_METHOD,constant("PUT"))
                .setHeader(Exchange.CONTENT_TYPE,constant("test/xml"))
                .setHeader(Exchange.HTTP_URI,simple("${properties:personServiceUri}/${headers.person_id}"))
                .to("http://dummy");
    }
}
