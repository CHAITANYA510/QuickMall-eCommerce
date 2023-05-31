package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsCategory;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsCategoryRequest;
import com.quickmall.productservice.model.PmsCategoryResponse;
import com.quickmall.productservice.repository.CategoryRespository;
import com.quickmall.productservice.serivce.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRespository categoryRespository;


    @Override
    public PmsCategoryResponse saveCategory(PmsCategoryRequest pmsCategoryRequest) {

        PmsCategory category = PmsCategory.builder()
                .categoryName(pmsCategoryRequest.getCategoryName())
                .parentId(pmsCategoryRequest.getParentId())
                .categoryLevel(pmsCategoryRequest.getCategoryLevel())
                .sort(pmsCategoryRequest.getSort())
                .build();

        categoryRespository.save(category);

        PmsCategoryResponse categoryResponse = new PmsCategoryResponse();

        copyProperties(category, categoryResponse);

        return categoryResponse;
    }

    @Override
    public List<PmsCategory> getAllCategory() {
        return categoryRespository.findAll();
    }

    @Override
    public PmsCategoryResponse getCategoryById(Long categoryId) {

        PmsCategory category = categoryRespository.findById(categoryId)
                .orElseThrow(() -> new BasicServiceException(
                   "categoryId - " + categoryId +
                   " does not exist! ",
                   "CATETRY_NOT_FOUND"
                ));

        PmsCategoryResponse categoryResponse = new PmsCategoryResponse();

        copyProperties(category, categoryResponse);

        return categoryResponse;
    }
}
