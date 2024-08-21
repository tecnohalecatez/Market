package com.hact.market.domain.service;

import com.hact.market.domain.DomainPurchase;
import com.hact.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<DomainPurchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<DomainPurchase>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public DomainPurchase save(DomainPurchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
