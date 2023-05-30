package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsAttriGroupRelation;
import com.quickmall.productservice.model.PmsAttriGroupRelationRequest;
import com.quickmall.productservice.model.PmsAttriGroupRelationResponse;
import com.quickmall.productservice.model.PmsAttriGroupResponse;
import com.quickmall.productservice.serivce.AttriGroupRelationService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product/v1/attriGroupRelation")
@RestController
@Log4j2
@Api(tags = "attriGroupRelation")

public class AttriGroupRelationController {

    @Autowired
    private AttriGroupRelationService agRelationService;


    @PostMapping
    public ResponseEntity<PmsAttriGroupRelationResponse> saveAgRelation(@RequestBody PmsAttriGroupRelationRequest agRelationRequest) {
        var agReponse = agRelationService.saveAgRelation(agRelationRequest);

        return new ResponseEntity<>(agReponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PmsAttriGroupRelation> getAllAgRelation() {
        return agRelationService.getAllAgRelation();
    }

    @GetMapping("/{agRelationId}")
    public ResponseEntity<PmsAttriGroupRelationResponse> getAgRelationById(@PathVariable("agRelationId") Long agRelationId) {
        var agResponse = agRelationService.getAgRelationById(agRelationId);

        return new ResponseEntity<>(agResponse, HttpStatus.OK);
    }

}
