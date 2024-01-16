package com.carlibassurance.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlibassurance.datalayer.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
