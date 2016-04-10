package hu.elte.iszraai.nir.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long              id;
    private String            name;
    private String            description;
    private Integer           stockQuantity;
    private Double            salePrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Column(length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Column(name = "stock_quantity", nullable = false)
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(final Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Column(name = "sale_price", nullable = false)
    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(final Double salePrice) {
        this.salePrice = salePrice;
    }

}
