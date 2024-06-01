package com.hact.market.persistence;

import com.hact.market.domain.DomainProduct;
import com.hact.market.domain.repository.ProductRepository;
import com.hact.market.persistence.crud.ProductCrudRepository;
import com.hact.market.persistence.entity.Product;
import com.hact.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersistenceProductRepository implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<DomainProduct> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<DomainProduct>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<DomainProduct>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndState(quantity, true);
        return products.map(prods -> mapper.toDomainProducts(prods));
    }


    public Optional<DomainProduct> getProduct(int idProduct) {
        return productCrudRepository.findById(idProduct).map(product -> mapper.toDomainProduct(product));
    }

    @Override
    public DomainProduct save(DomainProduct domainProduct) {
        Product product = mapper.toProduct(domainProduct);
        return mapper.toDomainProduct(productCrudRepository.save(product));
    }

    @Override
    public void delete(int idProduct) {
        productCrudRepository.deleteById(idProduct);
    }

}
