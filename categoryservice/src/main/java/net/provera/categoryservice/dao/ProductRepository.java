package net.provera.categoryservice.dao;

import net.provera.categoryservice.dao.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Category,Long>{

}
