package net.provera.productservice.mapper;



import net.provera.productservice.dao.model.Product;
import net.provera.productservice.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	 ProductDTO toProductDTO(Product product);
	 Product toProduct(ProductDTO productDTO);

}
