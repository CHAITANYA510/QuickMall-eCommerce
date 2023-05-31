package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsCategoryBrandRelation;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsCategoryBrandRelationRequest;
import com.quickmall.productservice.model.PmsCategoryBrandRelationResponse;
import com.quickmall.productservice.repository.CategoryBrandRepositroy;
import com.quickmall.productservice.serivce.CategoryBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Autowired
    private CategoryBrandRepositroy cbReposirtory;


    @Override
    public PmsCategoryBrandRelationResponse saveCbRelation(PmsCategoryBrandRelationRequest request) {

        PmsCategoryBrandRelation relationEntity = PmsCategoryBrandRelation.builder()
                .brandId(request.getBrandId())
                .brandName(request.getBrandName())
                .categoryId(request.getCategoryId())
                .categoryName(request.getCategoryName())
                .build();

        cbReposirtory.save(relationEntity);

        PmsCategoryBrandRelationResponse response = new PmsCategoryBrandRelationResponse();

        copyProperties(relationEntity, response);

        return response;
    }

    @Override
    public List<PmsCategoryBrandRelation> getAllCbRelatioin() {
        return cbReposirtory.findAll();
    }

    @Override
    public PmsCategoryBrandRelationResponse getCbById(Long cbRelationId) {

        PmsCategoryBrandRelation relationEntity = cbReposirtory.findById(cbRelationId)
                .orElseThrow(() -> new BasicServiceException(
                   "category-brand-relation - id." + cbRelationId + " does not exist!",
                   "CATEGORY_BRAND_RELATION_NOT_FOUND"
                ));

        PmsCategoryBrandRelationResponse response = new PmsCategoryBrandRelationResponse();

        copyProperties(relationEntity, response);

        return response;
    }
}
