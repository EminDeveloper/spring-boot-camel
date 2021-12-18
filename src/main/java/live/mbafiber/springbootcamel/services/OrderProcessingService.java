package live.mbafiber.springbootcamel.services;

import java.util.List;

import live.mbafiber.springbootcamel.models.Order;
import live.mbafiber.springbootcamel.models.OrderLine;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {

    @Autowired
    private ProducerTemplate producerTemplate;

    public Order process(final List<OrderLine> orderLines) {
        Order order = producerTemplate.requestBody(
                "direct:processOrder", orderLines, Order.class);

        return order;
    }

}