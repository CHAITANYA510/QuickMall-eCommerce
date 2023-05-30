package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsAttributeGroup;
import com.quickmall.productservice.model.PmsAttriGroupRequest;
import com.quickmall.productservice.model.PmsAttriGroupResponse;
import com.quickmall.productservice.serivce.AttriGroupService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product/v1/attriGroup")
@RestController
@Log4j2
@Api(tags = "AttriGroup")

public class AttriGroupController {

    @Autowired
    AttriGroupService attriGroupService;

    @PostMapping
    public ResponseEntity<PmsAttriGroupResponse> saveAttriGroup(@RequestBody PmsAttriGroupRequest attriGroupRequest) {
        var arrtiGroupResponse = attriGroupService.saveAttriGroup(attriGroupRequest);

        return new ResponseEntity<>(arrtiGroupResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PmsAttributeGroup> getAllAttriGroup() {
        return attriGroupService.getAllAttriGroup();
    }

    @GetMapping("/{attriGroupId}")
    public ResponseEntity<PmsAttriGroupResponse> getAttriGroupById(@PathVariable("attriGroupId") Long attriGroupId) {
        var attriGroupresponse = attriGroupService.getAttriGroupById(attriGroupId);

        return new ResponseEntity<>(attriGroupresponse, HttpStatus.OK);
    }

}
