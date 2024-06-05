package com.hact.market.persistence.mapper;

import com.hact.market.domain.DomainPurchaseItem;
import com.hact.market.persistence.entity.ProductPurchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "state", target = "active")
    })
    DomainPurchaseItem toDomainPurchaseItem(ProductPurchase productPurchase);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    ProductPurchase toProductPurchase(DomainPurchaseItem domainPurchaseItem);
}
