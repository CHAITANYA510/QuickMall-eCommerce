package com.quickmall.productservice.serivce;

import com.quickmall.productservice.entity.PmsBrand;
import com.quickmall.productservice.model.PmsBrandRequest;
import com.quickmall.productservice.model.PmsBrandResponse;

import java.util.List;

public interface BrandService {
    PmsBrandResponse saveBrand(PmsBrandRequest pmsBrandRequest);

    PmsBrandResponse getBrandById(Long brandId);

    List<PmsBrand> getAllBrand();
}
