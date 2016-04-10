package hu.elte.iszraai.nir.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.elte.iszraai.nir.domain.Customer;
import hu.elte.iszraai.nir.domain.Product;
import hu.elte.iszraai.nir.domain.Sale;
import hu.elte.iszraai.nir.service.CustomerRepository;
import hu.elte.iszraai.nir.service.ProductRepository;
import hu.elte.iszraai.nir.service.SaleRepository;

@RestController
@Transactional(readOnly = true)
public class StockController {

    @Autowired
    private ProductRepository  productRepository;
    @Autowired
    private SaleRepository     saleRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customers")
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @RequestMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @RequestMapping("/sales")
    public List<Sale> sales() {
        return saleRepository.findAllByOrderBySaleDateAsc();
    }

}
