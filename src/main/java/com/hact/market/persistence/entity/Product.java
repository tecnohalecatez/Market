package com.hact.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * The Product class represents a product entity in the database.
*/
@Entity
@Table(name = "productos", schema = "market")
@Getter
@Setter
public class Product {

    /**
     * The unique ID of the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProduct;

    /**
     * The name of the product.
     */
    @Column(name = "nombre")
    private String name;

    /**
     * The name of the product.
     */
    @Column(name = "id_categoria")
    private Integer idCategory;

    /**
     * The barcode of the product.
     */
    @Column(name = "codigo_barras")
    private String barcode;

    /**
     * The sale price of the product.
     */
    @Column(name = "precio_venta")
    private Double salePrice;

    /**
     * The quantity of the product in stock.
     */
    @Column(name = "cantidad_stock")
    private Integer stock;

    /**
     * The state of the product. True if the product is active, false otherwise.
     */
    @Column(name = "estado")
    private Boolean state;

    /**
     * The category associated with the product.
     */
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category category;

    /**
     * The purchases associated with the product.
     */
    @OneToMany(mappedBy = "product")
    private List<ProductPurchase> productPurchases;

}
