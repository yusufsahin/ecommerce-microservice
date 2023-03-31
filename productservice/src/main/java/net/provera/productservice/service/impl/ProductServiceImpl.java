package net.provera.productservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.provera.productservice.dao.ProductRepository;
import net.provera.productservice.dao.model.Product;
import net.provera.productservice.dto.ProductDTO;
import net.provera.productservice.exception.ProductNotFoundException;
import net.provera.productservice.mapper.ProductMapper;
import net.provera.productservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
		@Autowired
	    private final ProductRepository productRepository;
	    @Autowired
	    private final ProductMapper productMapper;

	    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
	        this.productRepository = productRepository;
	        this.productMapper = productMapper;
	    }


	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = productMapper.toProduct(productDTO);
		Product savedProduct = productRepository.save(product);
        return productMapper.toProductDTO(savedProduct);

	}

	@Override
	public List<ProductDTO> getAllProducts() {
		  List<Product> products = productRepository.findAll();
	        return products.stream()
	                .map(productMapper::toProductDTO)
	                .collect(Collectors.toList());

	}

	@Override
	public ProductDTO getProductById(String id) {
		Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return productMapper.toProductDTO(product);


	}

	@Override
	public ProductDTO updateProduct(String id, ProductDTO productDTO) {
		 var existingProduct = productRepository.findById(id)
	                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
	       existingProduct.setName(productDTO.getName());
	       existingProduct.setCategoryId(productDTO.getCategoryId());
	       existingProduct.setPrice(productDTO.getPrice());
	       existingProduct.setDescription(productDTO.getDescription());
	   
	      var updatedProduct = productRepository.save(existingProduct);
	        return productMapper.toProductDTO(updatedProduct);

	}

	@Override
	public void deleteProduct(String id) {
		Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);

		
	}

}
