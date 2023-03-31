package net.provera.cartservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import net.provera.cartservice.dao.model.*;

@Repository
public interface CartRepository extends CrudRepository<Cart,String>{

}
