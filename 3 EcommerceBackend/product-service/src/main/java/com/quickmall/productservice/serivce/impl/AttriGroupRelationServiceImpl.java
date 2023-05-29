package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsAttriGroupRelation;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsAttriGroupRelationRequest;
import com.quickmall.productservice.model.PmsAttriGroupRelationResponse;
import com.quickmall.productservice.model.PmsAttriGroupResponse;
import com.quickmall.productservice.repository.AttriGroupRelationRepository;
import com.quickmall.productservice.serivce.AttriGroupRelationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class AttriGroupRelationServiceImpl implements AttriGroupRelationService {

    @Autowired
    private AttriGroupRelationRepository agRelationRepository;


    @Override
    public PmsAttriGroupRelationResponse saveAgRelation(PmsAttriGroupRelationRequest agRelationRequest) {

        PmsAttriGroupRelation agRelation = PmsAttriGroupRelation.builder()
                .attributeGroupRelationId(agRelationRequest.getAttributeGroupRelationId())
                .attributeId(agRelationRequest.getAttributeId())
                .attributeGroupId(agRelationRequest.getAttributeGroupId())
                .build();

        agRelationRepository.save(agRelation);

        PmsAttriGroupRelationResponse agResponse = new PmsAttriGroupRelationResponse();

        copyProperties(agRelation, agResponse);

        log.info(agResponse);

        return agResponse;
    }

    @Override
    public List<PmsAttriGroupRelation> getAllAgRelation() {
        return agRelationRepository.findAll();
    }

    @Override
    public PmsAttriGroupRelationResponse getAgRelationById(Long agRelationId) {

        PmsAttriGroupRelation agRelation = agRelationRepository.findById(agRelationId)
                .orElseThrow(() -> new BasicServiceException(
                   "relationId - " + agRelationId + "does not exist! ",
                   "RELATION_NOT_FOUND"
                ));

        return null;
    }
}
