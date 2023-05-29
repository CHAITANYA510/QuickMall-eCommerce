package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsAttribute;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsAttributeRequest;
import com.quickmall.productservice.model.PmsAttributeResponse;
import com.quickmall.productservice.repository.AttributeRepository;
import com.quickmall.productservice.serivce.AttributeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    @Override
    public PmsAttributeResponse saveAttribute(PmsAttributeRequest attributeRequest) {

        PmsAttribute attribute = PmsAttribute.builder()
                .categoryId(attributeRequest.getCategoryId())
                .attributeName(attributeRequest.getAttributeName())
                .searchType(attributeRequest.getSearchType())
                .valueType(attributeRequest.getValueType())
                .icon(attributeRequest.getIcon())
                .valueSelect(attributeRequest.getValueSelect())
                .attributeType(attributeRequest.getAttributeType())
                .enable(attributeRequest.getEnable())
                .showDescription(attributeRequest.getShowDescription())
                .build();

        attributeRepository.save(attribute);

        PmsAttributeResponse attributeResponse = new PmsAttributeResponse();

        System.out.println("attribute" + attribute.toString());
        copyProperties(attribute, attributeResponse);

        log.info("attribute: " + attribute);

        log.info("attributeResponse: " + attributeResponse);

        return attributeResponse;
    }

    @Override
    public List<PmsAttribute> getAllAttribute() {
        return attributeRepository.findAll();
    }

    @Override
    public PmsAttributeResponse getAttributeById(Long attributeId) {

        PmsAttribute attribute = attributeRepository.findById(attributeId)
                .orElseThrow(() -> new BasicServiceException(
                   "attributeId - " + attributeId + " does not exsit!",
                   "ATTRIBUTE_NOT_FOUND"
                ));

        PmsAttributeResponse attributeResponse = new PmsAttributeResponse();

        copyProperties(attribute, attributeResponse);

        return attributeResponse;
    }
}
