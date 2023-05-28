package com.quickmall.productservice.serivce;

import com.quickmall.productservice.entity.PmsCategory;
import com.quickmall.productservice.model.PmsCategoryRequest;
import com.quickmall.productservice.model.PmsCategoryResponse;

import java.util.List;

public interface CategoryService {
    PmsCategoryResponse saveCategory(PmsCategoryRequest pmsCategoryRequest);

    List<PmsCategory> getAllCategory();

    PmsCategoryResponse getCategoryById(Long categoryId);
}
