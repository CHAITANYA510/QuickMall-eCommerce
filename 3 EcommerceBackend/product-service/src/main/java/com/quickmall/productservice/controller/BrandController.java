package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsBrand;
import com.quickmall.productservice.model.PmsBrandRequest;
import com.quickmall.productservice.model.PmsBrandResponse;
import com.quickmall.productservice.serivce.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/brand")
@RestController
@Log4j2
@Api(tags = "BrandInfo")

public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping()
    @ApiOperation("save Brand Information")
    public ResponseEntity<PmsBrandResponse> saveBrandInfo(@RequestBody PmsBrandRequest pmsBrandRequest) {
        var brandResponse = brandService.saveBrand(pmsBrandRequest);

        return new ResponseEntity<>(brandResponse, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation("get the Brand List")
    public List<PmsBrand> getAllBrand() {
        return brandService.getAllBrand();
    }

    @GetMapping("/{brandId}")
    @ApiOperation("find the Brand by brandId")
    public ResponseEntity<PmsBrandResponse> getBrandById(@PathVariable("brandId") Long brandId ) {
        var brandResponse = brandService.getBrandById(brandId);

        return new ResponseEntity<>(brandResponse, HttpStatus.ACCEPTED);
    }

}
