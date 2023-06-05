package com.quickmall.productservice.serivce;

import com.quickmall.productservice.entity.PmsSpu;
import com.quickmall.productservice.model.PmsSpuRequest;
import com.quickmall.productservice.model.PmsSpuResponse;

import java.util.List;

public interface SpuService {

    public PmsSpuResponse saveSpu(PmsSpuRequest pmsSpuRequest);

    public List<PmsSpu> getAllSpu();

    PmsSpuResponse getSpuById(Long spuId);

    PmsSpuResponse getSpuBySkuId(Long skuId);

    void deleteSpuById(Long spuId);
}
