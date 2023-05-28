package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsBrand;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsBrandRequest;
import com.quickmall.productservice.model.PmsBrandResponse;
import com.quickmall.productservice.model.PmsSpuResponse;
import com.quickmall.productservice.repository.BrandReoisitory;
import com.quickmall.productservice.serivce.BrandService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandReoisitory brandReoisitory;

    @Override
    public PmsBrandResponse saveBrand(PmsBrandRequest pmsBrandRequest) {

        PmsBrand pmsBrand = PmsBrand.builder()
                .brandId(pmsBrandRequest.getBrandId())
                .brandName(pmsBrandRequest.getBrandName())
                .logo(pmsBrandRequest.getLogo())
                .description(pmsBrandRequest.getDescription())
                .showStatus(pmsBrandRequest.getShowStatus())
                .firstLetter(pmsBrandRequest.getFirstLetter())
                .sort(pmsBrandRequest.getSort())
                .build();

        brandReoisitory.save(pmsBrand);

        PmsBrandResponse pmsBrandResponse = new PmsBrandResponse();

        copyProperties(pmsBrand, pmsBrandResponse);

        return pmsBrandResponse;
    }

    @Override
    public PmsBrandResponse getBrandById(Long brandId) {

        PmsBrand pmsBrand = brandReoisitory.findById(brandId)
                .orElseThrow(() -> new BasicServiceException(
                        "brand - " + brandId +
                                " does not exist! ",
                        "BRAND_NOT_FOUND"
                ));

        PmsBrandResponse pmsBrandResponse = new PmsBrandResponse();
        copyProperties(pmsBrand, pmsBrandResponse);

        return pmsBrandResponse;
    }

    @Override
    public List<PmsBrand> getAllBrand() {
        return brandReoisitory.findAll();
    }
}
