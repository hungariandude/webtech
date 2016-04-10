package hu.elte.iszraai.nir.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import hu.elte.iszraai.nir.domain.Customer;
import hu.elte.iszraai.nir.domain.Product;
import hu.elte.iszraai.nir.domain.Sale;
import hu.elte.iszraai.nir.service.CustomerRepository;
import hu.elte.iszraai.nir.service.ProductRepository;
import hu.elte.iszraai.nir.service.SaleRepository;
import io.spring.guides.gs_producing_web_service.NewPurchaseRequest;
import io.spring.guides.gs_producing_web_service.NewPurchaseResponse;
import io.spring.guides.gs_producing_web_service.Purchase;

@Endpoint
public class PurchaseEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    CustomerRepository          customerRepository;
    @Autowired
    ProductRepository           productRepository;
    @Autowired
    SaleRepository              saleRepository;

    @PayloadRoot(namespace = PurchaseEndpoint.NAMESPACE_URI, localPart = "newPurchaseRequest")
    @ResponsePayload
    public NewPurchaseResponse newPurchase(@RequestPayload final NewPurchaseRequest request) {
        NewPurchaseResponse response = new NewPurchaseResponse();

        Purchase purchase = request.getPurchase();

        Customer customer = customerRepository.findOne(purchase.getCustomerId());
        if (customer == null) {
            response.setError("Hibás vevő!");
            return response;
        }

        Product product = productRepository.findOne(purchase.getProductId());
        if (product == null) {
            response.setError("Hibás termék!");
            return response;
        }

        int quantity = purchase.getQuantity();
        if (quantity <= 0) {
            response.setError("A darabszámnak pozitívnak kell lennie!");
            return response;
        }

        if (product.getStockQuantity() < quantity) {
            response.setError("Nincs elég készlet a megadott termékből!");
            return response;
        }

        product.setStockQuantity(product.getStockQuantity() - quantity);
        productRepository.save(product);

        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setProduct(product);
        sale.setQuantity(quantity);
        sale.setPrice(product.getSalePrice());
        sale.setSaleDate(new Date());
        saleRepository.save(sale);

        return response;
    }

}
