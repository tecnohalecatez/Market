package com.hact.market.domain.repository;

import com.hact.market.domain.DomainPurchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<DomainPurchase> getAll();
    Optional<List<DomainPurchase>> getByClient(String clientId);
    DomainPurchase save(DomainPurchase purchase);
}
