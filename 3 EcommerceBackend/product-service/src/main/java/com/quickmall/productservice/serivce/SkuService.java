package com.quickmall.productservice.serivce;

import com.quickmall.productservice.entity.PmsSku;
import com.quickmall.productservice.model.PmsSkuRequest;
import com.quickmall.productservice.model.PmsSkuResponse;
import com.quickmall.productservice.model.PmsSpuResponse;

import java.util.List;

public interface SkuService {
    PmsSkuResponse saveSkuInfo(PmsSkuRequest skuRequest);

    List<PmsSku> getAllSkuInfo();

    PmsSkuResponse getSkuById(Long skuId);
}
