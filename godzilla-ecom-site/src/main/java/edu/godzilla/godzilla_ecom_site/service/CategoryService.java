package edu.godzilla.godzilla_ecom_site.service;

import edu.godzilla.godzilla_ecom_site.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    String createCategory(Category category);
    String deleteCategory(long categoryId);
    void updateCategory(Category updateCategory, long categoryId);
}
