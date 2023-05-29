package com.quickmall.productservice.serivce;

import com.quickmall.productservice.entity.PmsAttribute;
import com.quickmall.productservice.model.PmsAttributeRequest;
import com.quickmall.productservice.model.PmsAttributeResponse;

import java.util.List;

public interface AttributeService {
    PmsAttributeResponse saveAttribute(PmsAttributeRequest pmsAttributeRequest);


    List<PmsAttribute> getAllAttribute();

    PmsAttributeResponse getAttributeById(Long attributeId);
}
