package live.mbafiber.springbootcamel.routes;

import live.mbafiber.springbootcamel.services.PriceAggregationStrategy;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessingRoute   extends RouteBuilder {

    @Autowired
    private PriceAggregationStrategy priceAggregationStrategy;

    @Override
    public void configure() throws Exception {
        from("direct:fetchProcess")
                .split(body(), priceAggregationStrategy).parallelProcessing()
                .to("bean:pricingService?method=calculatePrice")
                .end();
    }

}