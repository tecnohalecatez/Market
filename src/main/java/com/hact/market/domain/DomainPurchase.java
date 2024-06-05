package com.hact.market.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DomainPurchase {
    private Integer purchaseId;
    private Integer clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<DomainPurchaseItem> items;
}
