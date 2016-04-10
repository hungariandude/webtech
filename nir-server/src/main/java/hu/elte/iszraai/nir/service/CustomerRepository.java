package hu.elte.iszraai.nir.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.elte.iszraai.nir.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
