package edu.godzilla.godzilla_ecom_site.service;

import edu.godzilla.godzilla_ecom_site.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return "Category name: "+category.getCategoryName()+" : created successfully!";
    }

    @Override
    public String deleteCategory(long categoryId) {
        Category status = categories.stream()
                .filter(category -> category.getCategoryId() == categoryId)
                .findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Sorry, Resource Not Found"));

        categories.remove(status);
        return "Deleted successfully !";
    }

    @Override
    public void updateCategory(Category updateCategory, long categoryId) {
        Category status = categories.stream().filter(
                category -> categoryId == category.getCategoryId())
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        status.setCategoryName(updateCategory.getCategoryName());
    }
}
