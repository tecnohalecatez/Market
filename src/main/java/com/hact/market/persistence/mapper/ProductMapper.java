package com.hact.market.persistence.mapper;

import com.hact.market.domain.DomainProduct;
import com.hact.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @org.mapstruct.Mapping(source = "idProduct", target = "productId"),
            @org.mapstruct.Mapping(source = "name", target = "name"),
            @org.mapstruct.Mapping(source = "idCategory", target = "categoryId"),
            @org.mapstruct.Mapping(source = "salePrice", target = "price"),
            @org.mapstruct.Mapping(source = "stock", target = "stock"),
            @org.mapstruct.Mapping(source = "state", target = "active"),
            @org.mapstruct.Mapping(source = "category", target = "category")
    })
    DomainProduct toDomainProduct(Product product);
    List<DomainProduct> toDomainProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    @Mapping(target = "productPurchases", ignore = true)
    Product toProduct(DomainProduct product);
}
