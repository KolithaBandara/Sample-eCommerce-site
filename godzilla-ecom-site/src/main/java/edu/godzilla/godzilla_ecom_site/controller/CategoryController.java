package edu.godzilla.godzilla_ecom_site.controller;

import edu.godzilla.godzilla_ecom_site.model.Category;
import edu.godzilla.godzilla_ecom_site.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category named "+category.getCategoryName()+" created successfully!";
    }

    @DeleteMapping("/api/public/categories/{categoryId}/delete")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId){
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }catch (ResponseStatusException responseStatusException){
            return new ResponseEntity<>(responseStatusException.getReason(),
                    responseStatusException.getStatusCode());
        }
    }

}
