package com.hact.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The ProductPurchase class represents a product purchase entity in the database.
 */
@Entity
@Table(name = "compras_productos", schema = "market")
@Getter
@Setter
public class ProductPurchase {
    /**
     * The primary key of the product purchase.
     */
    @EmbeddedId
    private ProductPurchasePK id;

    /**
     * The quantity of the product in the purchase.
     */
    @Column(name = "cantidad")
    private Integer quantity;

    /**
     * The total price of the product in the purchase.
     */
    @Column(name = "total")
    private Double total;

    /**
     * The state of the product purchase. True if the product purchase is active, false otherwise.
     */
    @Column(name = "estado")
    private Boolean state;

    /**
     * The product associated with the product purchase.
     */
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    /**
     * The purchase associated with the product purchase.
     */
    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;
}
