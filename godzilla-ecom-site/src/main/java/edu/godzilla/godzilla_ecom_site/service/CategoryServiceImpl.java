package edu.godzilla.godzilla_ecom_site.service;

import edu.godzilla.godzilla_ecom_site.model.Category;
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

    @Override
    public String deleteCategory(long categoryId) {
        Category status = categories.stream()
                .filter(category -> category.getCategoryId() == categoryId)
                .findFirst().orElse(null);
        if (status == null) return "Category not found :/";

        categories.remove(status);
        return "Deleted successfully !";
    }
}
