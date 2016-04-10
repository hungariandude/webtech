package hu.elte.iszraai.nir.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long              id;
    private Product           product;
    private Customer          customer;
    private Integer           quantity;
    private Double            price;
    private Date              saleDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    @Column(nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    @Column(nullable = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_date", nullable = false)
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(final Date saleDate) {
        this.saleDate = saleDate;
    }

}
