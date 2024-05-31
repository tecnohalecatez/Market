package com.hact.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainProduct {
    private Integer productId;
    private Integer categoryId;
    private String name;
    private double price;
    private int stock;
    private boolean active;
    private DomainCategory category;
}
