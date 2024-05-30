package com.hact.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The ProductPurchasePK class represents a product purchase primary key entity in the database.
 */
@Embeddable
@Getter
@Setter
public class ProductPurchasePK {
    /**
     * The ID of the purchase.
     */
    @Column(name = "id_compra")
    private Integer idPurchase;

    /**
     * The ID of the product.
     */
    @Column(name = "id_producto")
    private Integer idProduct;

}
