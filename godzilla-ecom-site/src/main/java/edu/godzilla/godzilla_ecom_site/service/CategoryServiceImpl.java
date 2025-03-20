package edu.godzilla.godzilla_ecom_site.service;

import edu.godzilla.godzilla_ecom_site.controller.CategoryController;
import edu.godzilla.godzilla_ecom_site.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements  CategoryService{

    private List<Category> categories = new ArrayList<>();
    private long categoryId = 0l;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public String createCategory(Category category) {
        category.setCategoryId(++categoryId);
        categories.add(category);
        return "Category named "+category.getCategoryName()+" created successfully!";
    }
}
