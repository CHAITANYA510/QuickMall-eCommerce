package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsAttribute;
import com.quickmall.productservice.model.PmsAttributeRequest;
import com.quickmall.productservice.model.PmsAttributeResponse;
import com.quickmall.productservice.serivce.AttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product/v1/attribute")
@RestController
@Log4j2
@Api(tags = "AttributeInfo")

public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping()
    @ApiOperation("save Attribute Information")
    public ResponseEntity<PmsAttributeResponse> saveBrandInfo(@RequestBody PmsAttributeRequest pmsAttributeRequest) {
        var attributeResponse = attributeService.saveAttribute(pmsAttributeRequest);

        log.info("** attributeResponse : " + attributeResponse);
        return new ResponseEntity<>(attributeResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PmsAttribute> getAllAttribute() {
        return attributeService.getAllAttribute();
    }

    @GetMapping("/{attributeId}")
    public ResponseEntity<PmsAttributeResponse> getAllAttributeById(@PathVariable("attributeId") Long attributeId) {
        var attributeResponse = attributeService.getAttributeById(attributeId);

        return new ResponseEntity<>(attributeResponse, HttpStatus.ACCEPTED);
    }


}
