package live.mbafiber.springbootcamel;

import java.util.List;

import live.mbafiber.springbootcamel.models.Product;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResource {

    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping("/products/{category}")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable("category") final String category){
        producerTemplate.start();
        List<Product> products = producerTemplate.requestBody("direct:fetchProducts", category, List.class);
        System.out.println("products "+products);
        producerTemplate.stop();
        return products;

    }

}