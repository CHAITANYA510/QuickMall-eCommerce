package com.quickmall.orderservice.external.client;

import com.quickmall.orderservice.model.PmsSkuResponse;
import com.quickmall.orderservice.model.PmsSpuResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE/api/product/v1")
public interface ProductFeignService {

    /**
     * get SpuInfo via SkuId - spuController
     */
    @GetMapping("/spu/sku/{spuId}")
    public ResponseEntity<PmsSpuResponse> getSpuBySkuId(@PathVariable("spuId") Long skuId);

    /**
     * reduce sku in product service
     */
    @GetMapping("/sku/{skuId}")
    public ResponseEntity<PmsSkuResponse> getSkuById(@PathVariable("skuId") Long skuId);

}
