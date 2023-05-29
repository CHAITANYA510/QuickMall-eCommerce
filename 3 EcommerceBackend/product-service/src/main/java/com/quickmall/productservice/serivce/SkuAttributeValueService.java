package com.quickmall.productservice.serivce;

import com.quickmall.productservice.entity.PmsSkuAttributeValue;
import com.quickmall.productservice.model.PmsSkuAttributeValueRequest;
import com.quickmall.productservice.model.PmsSkuAttributeValueResponse;

import java.util.List;

public interface SkuAttributeValueService {

    PmsSkuAttributeValueResponse saveSkuAttValue(PmsSkuAttributeValueRequest request);

    List<PmsSkuAttributeValue> getAllSkuAttVal();

    PmsSkuAttributeValueResponse getSkuAttValById(Long skuAttValId);
}
