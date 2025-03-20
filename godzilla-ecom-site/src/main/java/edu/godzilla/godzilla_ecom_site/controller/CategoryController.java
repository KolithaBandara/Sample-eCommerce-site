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
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        String status = categoryService.createCategory(category);
        return new ResponseEntity<>(status,HttpStatus.CREATED);
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

    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(
            @RequestBody Category updateCategory,
            @PathVariable long categoryId){
        try {
            categoryService.updateCategory(updateCategory, categoryId);
            return new ResponseEntity<>("Updated Successfully !",HttpStatus.OK);
        }catch (ResponseStatusException responseStatusException){
            return new ResponseEntity<>(
                    "Can not found the category !",
                    HttpStatus.NOT_FOUND);
        }
    }

}
