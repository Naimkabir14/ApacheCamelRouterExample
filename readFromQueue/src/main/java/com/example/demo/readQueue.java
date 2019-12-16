package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class readQueue extends RouteBuilder {
    @Autowired
    private payloadRepo plRepo;

    @Override
    public void configure() throws Exception {
        from("jms:queue:testQueue")
                .choice()
                .when(header("CamelFileNameOnly").isEqualTo("Example.xml"))
                    .process(exchange -> {
                        String header = exchange.getIn().getHeader("CamelFileNameOnly").toString();
                        String payload = exchange.getIn().getBody(String.class);
                        plRepo.save(new payloadReception(header, payload));
                    })
                    .to("jms:queue:BrooklynOrder.xml")
                .otherwise()
                    .process(exchange -> {
                        String header = exchange.getIn().getHeader("CamelFileNameOnly").toString();
                        String payload = exchange.getIn().getBody(String.class);
                        plRepo.save(new payloadReception(header, payload));
//                        System.out.print(exchange.getIn().getBody(String.class));
                    })
                    .to("jms:queue:Other.xml");


    }
}
