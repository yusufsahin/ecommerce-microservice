package net.provera.productservice.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.provera.productservice.dao.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findByCategoryId(String categoryId);

}
