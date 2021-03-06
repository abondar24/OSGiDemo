package org.abondar.experimental.order;


import org.apache.camel.builder.RouteBuilder;

public class OrderRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:ordersin?noop=true").id("order")
                .setHeader("customer", xpath("/order/customer/text()").stringResult())
                .split(xpath("/order/item"))
                .setHeader("count", xpath("/item/@count").stringResult())
                .setHeader("name", xpath("/item/@name").stringResult())
                .to("direct:vendor");


        from("direct:vendor").id("mailtovendor")
                .setHeader("to",method("vendorMailService"))
                .setHeader("subject",simple("Order from ${header.customer}"))
                .to("velocity:mailtemplate.txt")
                .to("stream:out")
              //  .to("smtp:{{mailserver}}");
                .to("smtp:localhost");
    }
}
