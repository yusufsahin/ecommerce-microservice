package net.provera.categoryservice.service;

import java.util.List;

import net.provera.categoryservice.dto.CategoryDTO;

public interface CategoryService {
	 	CategoryDTO createCategory(CategoryDTO categoryDTO);

	    List<CategoryDTO> getAllCategories();

	    CategoryDTO getCategoryById(Long id);

	    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

	    void deleteCategory(Long id);


}
