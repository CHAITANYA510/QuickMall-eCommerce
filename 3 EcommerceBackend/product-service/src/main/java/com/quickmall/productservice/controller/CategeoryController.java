package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsCategory;
import com.quickmall.productservice.model.PmsCategoryRequest;
import com.quickmall.productservice.model.PmsCategoryResponse;
import com.quickmall.productservice.serivce.CategoryService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/category")
@RestController
@Log4j2
@Api(tags = "CategoryInfo")

public class CategeoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<PmsCategoryResponse> saveCategory(@RequestBody PmsCategoryRequest pmsCategoryRequest) {

        var pmsCategoryResponse = categoryService.saveCategory(pmsCategoryRequest);

        return new ResponseEntity<>(pmsCategoryResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PmsCategory> getAllCategory() {
            return categoryService.getAllCategory();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<PmsCategoryResponse> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        var categoryResponse = categoryService.getCategoryById(categoryId);

        return new ResponseEntity<>(categoryResponse, HttpStatus.ACCEPTED);
    }

}
