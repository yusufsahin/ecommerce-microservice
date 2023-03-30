package net.provera.categoryservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.provera.categoryservice.dao.ProductRepository;
import net.provera.categoryservice.dto.CategoryDTO;
import net.provera.categoryservice.exception.CategoryNotFoundException;
import net.provera.categoryservice.service.CategoryService;
import net.provera.categoryservice.dao.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
    private final ProductRepository categoryRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(ProductRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }



	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		 List<Category> categories = categoryRepository.findAll();
	        return categories.stream()
	                .map(category -> modelMapper.map(category, CategoryDTO.class))
	                .collect(Collectors.toList());
	}

	@Override
	public CategoryDTO getCategoryById(Long id) {
		Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        return modelMapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
		Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
		existingCategory.setName(categoryDTO.getName());
        var updatedCategory = categoryRepository.save(existingCategory);
        return modelMapper.map(updatedCategory, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Long id) {
		Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        categoryRepository.delete(category);
		
	}

}
