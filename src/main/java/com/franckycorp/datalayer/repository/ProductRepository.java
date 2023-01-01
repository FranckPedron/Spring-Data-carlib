package com.franckycorp.datalayer.repository;

import com.franckycorp.datalayer.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    public Iterable<Product> findByName(String name);

    public Iterable<Product> findByCategoriesName(String name);

    @Query("from Product where name = ?1")
    public Iterable<Product> findByNameJPQL(String name);

    @Query(value = "select * from produit where cout = :cout", nativeQuery = true)
    public Iterable<Product> findByCostNative(@Param("cout") Integer cost);

    public Iterable<Product> findByCostLessThan(Integer cost);
}
