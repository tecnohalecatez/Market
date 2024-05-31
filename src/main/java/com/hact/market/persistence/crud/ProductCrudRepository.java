package com.hact.market.persistence.crud;

import com.hact.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    List<Product> findByIdCategoryOrderByNameAsc(Integer idCategory);
    Optional<List<Product>> findByStockLessThanAndState(Integer stock, Boolean state);

}
