package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsAttributeGroup;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsAttriGroupRequest;
import com.quickmall.productservice.model.PmsAttriGroupResponse;
import com.quickmall.productservice.repository.AttriGroupRepository;
import com.quickmall.productservice.serivce.AttriGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class AttriGroupServiceImpl implements AttriGroupService {

    @Autowired
    private AttriGroupRepository attriGroupRepository;

    @Override
    public PmsAttriGroupResponse saveAttriGroup(PmsAttriGroupRequest attriGroupRequest) {

        PmsAttributeGroup attributeGroup = PmsAttributeGroup.builder()
                .attributeGroupId(attriGroupRequest.getAttributeGroupId())
                .categoryId(attriGroupRequest.getCategoryId())
                .attributeGroupName(attriGroupRequest.getAttributeGroupName())
                .sort(attriGroupRequest.getSort())
                .description(attriGroupRequest.getDescription())
                .icon(attriGroupRequest.getIcon())
                .build();

        attriGroupRepository.save(attributeGroup);

        PmsAttriGroupResponse attriGroupResponse = new PmsAttriGroupResponse();

        copyProperties(attributeGroup, attriGroupResponse);

        return attriGroupResponse;
    }

    @Override
    public List<PmsAttributeGroup> getAllAttriGroup() {
        return attriGroupRepository.findAll();
    }

    @Override
    public PmsAttriGroupResponse getAttriGroupById(Long attriGroupId) {

        PmsAttributeGroup attributeGroup = attriGroupRepository.findById(attriGroupId)
                .orElseThrow(() -> new BasicServiceException(
                   "attriGroupId - " + attriGroupId + " does not exist!",
                   "ATTRIBUTEGROUP_NOT_FOUND"
                ));

        PmsAttriGroupResponse attriGroupResponse = new PmsAttriGroupResponse();

        copyProperties(attributeGroup, attriGroupResponse);
        return attriGroupResponse;
    }
}
