package com.quickmall.cartservice.external;

import com.quickmall.cartservice.model.PmsSkuResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE/api/product/v1")
public interface ProductFeignService {

    /**
     *
     * @param skuId
     * @return
     */
    @GetMapping("/{skuId}")
    public ResponseEntity<PmsSkuResponse> getSkuById(@PathVariable("skuId") Long skuId);
}
