package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsSkuAttributeValue;
import com.quickmall.productservice.model.PmsSkuAttributeValueRequest;
import com.quickmall.productservice.model.PmsSkuAttributeValueResponse;
import com.quickmall.productservice.serivce.SkuAttributeValueService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/skuAttriValue")
@RestController
@Log4j2
@Api(tags = "SkuAttributeValue")


public class SkuAttributeValueController {

    @Autowired
    SkuAttributeValueService skuAttValueService;

    @PostMapping
    public ResponseEntity<PmsSkuAttributeValueResponse> saveSkuAttValue(@RequestBody PmsSkuAttributeValueRequest request) {
        var response = skuAttValueService.saveSkuAttValue(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PmsSkuAttributeValue> getAllSkuAttVal() {
        return skuAttValueService.getAllSkuAttVal();
    }

    @GetMapping("/{skuAttValId}")
    public ResponseEntity<PmsSkuAttributeValueResponse> getSkuAttValById(@PathVariable("skuAttValId") Long skuAttValId) {
        var response = skuAttValueService.getSkuAttValById(skuAttValId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
