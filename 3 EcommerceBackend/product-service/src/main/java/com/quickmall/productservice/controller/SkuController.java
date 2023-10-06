package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsSku;
import com.quickmall.productservice.model.PmsSkuRequest;
import com.quickmall.productservice.model.PmsSkuResponse;
import com.quickmall.productservice.serivce.SkuService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product/v1/sku")
@RestController
@Log4j2
@Api(tags = "SkuInfo")

public class SkuController {

    @Autowired
    SkuService skuService;

    @PostMapping
    public ResponseEntity<PmsSkuResponse> saveSkuInfo(@RequestBody PmsSkuRequest skuRequest) {
        var skuResponse = skuService.saveSkuInfo(skuRequest);

        return new ResponseEntity<>(skuResponse, HttpStatus.CREATED);

    }

    @GetMapping
    public List<PmsSku> getAllSku () {
        return skuService.getAllSkuInfo();
    }

    @GetMapping("/{skuId}")
    public ResponseEntity<PmsSkuResponse> getSkuById(@PathVariable("skuId") Long skuId) {
        var skuResponse = skuService.getSkuById(skuId);

        return new ResponseEntity<>(skuResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{skuId}")
    public void deleteSkuById(@PathVariable("skuId") Long skuId) {
        skuService.deleteSkuById(skuId);
    }

    /**
     * reduce the sku stock after a successful payment
     * @param skuId
     * @param reductQuantity
     * @return
     */
    @PutMapping("/changeQuantity/{skuId}")
    //http://localhost:9001/api/product/v1/sku/reduceQuantity/2?reduceQuantity=1
    public ResponseEntity<Void> reduceQuantity(@PathVariable("skuId") Long skuId,
                                               @RequestParam Integer reductQuantity) {
        skuService.reduceQuantity(skuId, reductQuantity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
