package com.hact.market.persistence;

import com.hact.market.persistence.crud.ProductCrudRepository;
import com.hact.market.persistence.entity.Product;
import java.util.List;

public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory) {
        return productCrudRepository.findByIdCategory(idCategory);
    }

    public List<Product> getByCategoryOrderByNameAsc(int idCategory) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }
}
