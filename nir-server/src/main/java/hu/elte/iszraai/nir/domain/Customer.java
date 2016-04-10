package hu.elte.iszraai.nir.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long              id;
    private String            name;
    private String            address;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
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

    @Column(nullable = false, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

}
