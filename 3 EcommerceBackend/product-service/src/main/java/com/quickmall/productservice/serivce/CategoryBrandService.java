package com.quickmall.productservice.serivce;

import com.quickmall.productservice.entity.PmsCategoryBrandRelation;
import com.quickmall.productservice.model.PmsCategoryBrandRelationRequest;
import com.quickmall.productservice.model.PmsCategoryBrandRelationResponse;

import java.util.List;

public interface CategoryBrandService {
    PmsCategoryBrandRelationResponse saveCbRelation(PmsCategoryBrandRelationRequest request);

    List<PmsCategoryBrandRelation> getAllCbRelatioin();

    PmsCategoryBrandRelationResponse getCbById(Long cbRelationId);
}
