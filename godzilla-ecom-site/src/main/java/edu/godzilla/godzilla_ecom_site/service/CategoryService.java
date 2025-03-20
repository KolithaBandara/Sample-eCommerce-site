package edu.godzilla.godzilla_ecom_site.service;

import edu.godzilla.godzilla_ecom_site.model.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    String createCategory(Category category);
}
