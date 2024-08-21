package com.hact.market.persistence;

import com.hact.market.domain.DomainPurchase;
import com.hact.market.domain.repository.PurchaseRepository;
import com.hact.market.persistence.crud.PurchaseCrudRepository;
import com.hact.market.persistence.entity.Purchase;
import com.hact.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersistencePurchaseRepository implements PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<DomainPurchase> getAll() {
        return purchaseMapper.toDomainPurchases((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<DomainPurchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId).map(purchases -> purchaseMapper.toDomainPurchases(purchases));
    }

    @Override
    public DomainPurchase save(DomainPurchase purchase) {
        Purchase purchaseNew = purchaseMapper.toPurchase(purchase);
        purchaseNew.getProductPurchases().forEach(productPurchase -> productPurchase.setPurchase(purchaseNew));
        return purchaseMapper.toDomainPurchase(purchaseCrudRepository.save(purchaseNew));
    }
}
