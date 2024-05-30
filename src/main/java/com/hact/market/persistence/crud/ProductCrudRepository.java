package com.hact.market.persistence.crud;

import com.hact.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    List<Product> findByIdCategory(Integer idCategory);

    List<Product> findByIdCategoryOrderByNameAsc(Integer idCategory);
}
