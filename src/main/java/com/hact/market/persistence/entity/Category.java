package com.hact.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * The Category class represents a category entity in the database.
 */
@Entity
@Table(name = "categorias")
@Getter
@Setter
public class Category {
    /**
     * The unique ID of the category.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategory;

    /**
     * The name of the category.
     */
    @Column(name = "descripcion")
    private String description;

    /**
     * The state of the category. True if the category is active, false otherwise.
     */
    @Column(name = "estado")
    private Boolean state;

    /**
     * The products associated with the category.
     */
    @OneToMany(mappedBy = "category")
    private List<Product> products;

 }
