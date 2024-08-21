package com.hact.market.persistence.crud;

import com.hact.market.domain.DomainPurchase;
import com.hact.market.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Integer> {
    Optional<List<Purchase>> findByIdClient(String idClient);
}
