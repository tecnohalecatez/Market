package com.hact.market.persistence.mapper;

import com.hact.market.domain.DomainCategory;
import com.hact.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @org.mapstruct.Mapping(source = "idCategory", target = "categoryId"),
            @org.mapstruct.Mapping(source = "description", target = "category"),
            @org.mapstruct.Mapping(source = "state", target = "active")
    })
    DomainCategory toCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(DomainCategory category);
}
