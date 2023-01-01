package com.franckycorp.datalayer.repository;

import com.franckycorp.datalayer.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByName(String name);

    Iterable<Product> findByCategoriesName(String name);

}
