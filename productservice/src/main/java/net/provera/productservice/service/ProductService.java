package net.provera.productservice.service;

import java.util.List;
import net.provera.productservice.dto.ProductDTO;

public interface ProductService {
	ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(String id);

    ProductDTO updateProduct(String id, ProductDTO productDTO);

    void deleteProduct(String id);


}
