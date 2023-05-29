package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsCategoryBrandRelation;
import com.quickmall.productservice.model.PmsCategoryBrandRelationRequest;
import com.quickmall.productservice.model.PmsCategoryBrandRelationResponse;
import com.quickmall.productservice.serivce.CategoryBrandService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/categoryBrand")
@RestController
@Log4j2
@Api(tags = "categoryBrand Relation")

public class CategoryBrandController {

    @Autowired
    private CategoryBrandService cbService;

    @PostMapping
    public ResponseEntity<PmsCategoryBrandRelationResponse> saveCbRelation(@RequestBody PmsCategoryBrandRelationRequest request){

        var response = cbService.saveCbRelation(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PmsCategoryBrandRelation> getAllCbRelatioin() {
        return cbService.getAllCbRelatioin();
    }

    @GetMapping("/{cbRelationId}")
    public ResponseEntity<PmsCategoryBrandRelationResponse> getCbById(@PathVariable("cbRelationId") Long cbRelationId) {
        var response = cbService.getCbById(cbRelationId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
