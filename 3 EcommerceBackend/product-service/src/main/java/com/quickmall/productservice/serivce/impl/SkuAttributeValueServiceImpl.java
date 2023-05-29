package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsSkuAttributeValue;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsSkuAttributeValueRequest;
import com.quickmall.productservice.model.PmsSkuAttributeValueResponse;
import com.quickmall.productservice.repository.SkuAttributeValueRepositroy;
import com.quickmall.productservice.serivce.SkuAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class SkuAttributeValueServiceImpl implements SkuAttributeValueService {

    @Autowired
    private SkuAttributeValueRepositroy skuAttriValRepo;

    @Override
    public PmsSkuAttributeValueResponse saveSkuAttValue(PmsSkuAttributeValueRequest request) {

        PmsSkuAttributeValue skuAttVal = PmsSkuAttributeValue.builder()
                .skuId(request.getSkuId())
                .attributeId(request.getAttributeId())
                .attributeName(request.getAttributeName())
                .attributeValue(request.getAttributeValue())
                .build();

        skuAttriValRepo.save(skuAttVal);

        PmsSkuAttributeValueResponse response = new PmsSkuAttributeValueResponse();

        copyProperties(skuAttVal, response);

        return response;
    }

    @Override
    public List<PmsSkuAttributeValue> getAllSkuAttVal() {
        return skuAttriValRepo.findAll();
    }

    @Override
    public PmsSkuAttributeValueResponse getSkuAttValById(Long skuAttValId) {

        PmsSkuAttributeValue skuAttVal = skuAttriValRepo.findById(skuAttValId)
                .orElseThrow(() -> new BasicServiceException(
                   "skuAttValId - " + skuAttValId + " does not exist! ",
                   "SKU_ATTRIBUTE_VALUE_NOT_FOUND"
                ));

        PmsSkuAttributeValueResponse response = new PmsSkuAttributeValueResponse();

        copyProperties(skuAttVal, response);

        return response;
    }
}
