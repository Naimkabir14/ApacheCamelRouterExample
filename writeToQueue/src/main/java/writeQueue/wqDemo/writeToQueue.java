package writeQueue.wqDemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class writeToQueue extends RouteBuilder {

    @Autowired
    private payloadRepo plRepo;

    @Override
    public void configure() throws Exception {
        from("file:C:{add folder to read files from}?noop=true<-this retains file in directory after transfer to queue").process(exchange -> {
            plRepo.deleteAll();
        }).to("jms:queue:testQueue");
    }
}
