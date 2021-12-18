package live.mbafiber.springbootcamel.services;

import java.util.ArrayList;
import java.util.List;

import live.mbafiber.springbootcamel.models.OrderLine;
import live.mbafiber.springbootcamel.models.Product;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    public double getPrice(final String productName) {

        return 2.4;

    }

    public List<OrderLine> generateOrder() {
        System.out.println("generating orders");

        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(new Product("Television", "Electronics"));

        orderLines.add(orderLine);

        orderLine = new OrderLine();
        orderLine.setProduct(new Product("Washing Machine", "Household"));

        orderLines.add(orderLine);
        return orderLines;
    }

    public List<Product> fetchProductsByCategory(final String category) {
        System.out.println("fetching products of category "+category);

        List<Product> products = new ArrayList<Product>();


        products.add(new Product("Television","Electronics"));
        products.add(new Product("Washing Machine","Household"));
        return products;
    }


}