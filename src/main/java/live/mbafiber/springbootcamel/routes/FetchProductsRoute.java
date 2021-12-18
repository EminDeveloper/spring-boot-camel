package live.mbafiber.springbootcamel.routes;


import live.mbafiber.springbootcamel.services.ProductService;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author pratikdas
 *
 */
@Component
public class FetchProductsRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:fetchProducts")
                .routeId("direct-fetchProducts")
                .tracing()
                .log(">>> ${body}")
                .bean(ProductService.class, "fetchProductsByCategory")
                .end();
    }

}