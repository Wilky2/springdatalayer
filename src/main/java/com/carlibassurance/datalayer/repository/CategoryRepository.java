package com.carlibassurance.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlibassurance.datalayer.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
