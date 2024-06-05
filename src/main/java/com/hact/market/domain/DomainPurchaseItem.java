package com.hact.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainPurchaseItem {
    private Integer productId;
    private Integer quantity;
    private Double total;
    private Boolean active;

}
