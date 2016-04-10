package hu.elte.iszraai.nir.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.elte.iszraai.nir.domain.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllByOrderBySaleDateAsc();

}
