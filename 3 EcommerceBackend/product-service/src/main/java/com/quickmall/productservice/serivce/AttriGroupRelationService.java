package com.quickmall.productservice.serivce;

import com.quickmall.productservice.entity.PmsAttriGroupRelation;
import com.quickmall.productservice.model.PmsAttriGroupRelationRequest;
import com.quickmall.productservice.model.PmsAttriGroupRelationResponse;
import com.quickmall.productservice.model.PmsAttriGroupResponse;

import java.util.List;

public interface AttriGroupRelationService {
    PmsAttriGroupRelationResponse saveAgRelation(PmsAttriGroupRelationRequest agRelationRequest);

    List<PmsAttriGroupRelation> getAllAgRelation();

    PmsAttriGroupRelationResponse getAgRelationById(Long agRelationId);
}
