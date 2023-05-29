package com.quickmall.productservice.serivce;


import com.quickmall.productservice.entity.PmsAttributeGroup;
import com.quickmall.productservice.model.PmsAttriGroupRequest;
import com.quickmall.productservice.model.PmsAttriGroupResponse;

import java.util.List;

public interface AttriGroupService {
    PmsAttriGroupResponse saveAttriGroup(PmsAttriGroupRequest attriGroupRequest);

    List<PmsAttributeGroup> getAllAttriGroup();

    PmsAttriGroupResponse getAttriGroupById(Long attriGroupId);
}
