package com.hact.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The Purchase class represents a purchase entity in the database.
 */
@Entity
@Table(name = "compras")
@Getter
@Setter
public class Purchase {
    /**
     * The unique ID of the purchase.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idPurchase;

    /**
     * The ID of the client who made the purchase.
     */
    @Column(name = "id_cliente")
    private String idClient;

    /**
     * The date of the purchase.
     */
    @Column(name = "fecha")
    private LocalDateTime date;

    /**
     * The payment method used in the purchase.
     */
    @Column(name = "medio_pago")
    private String paymentMethod;

    /**
     * The comment of the purchase.
     */
    @Column(name = "comentario")
    private String comment;

    /**
     * The state of the purchase. True if the purchase is active, false otherwise.
     */
    @Column(name = "estado")
    private String state;

    /**
     * The client associated with the purchase.
     */
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Client client;

    /**
     * The products associated with the purchase.
     */
    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL})
    private List<ProductPurchase> productPurchases;

}
