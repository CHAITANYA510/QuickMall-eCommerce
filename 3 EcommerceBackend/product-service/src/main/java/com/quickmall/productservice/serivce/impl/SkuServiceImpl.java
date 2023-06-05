package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsSku;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsSkuRequest;
import com.quickmall.productservice.model.PmsSkuResponse;
import com.quickmall.productservice.repository.SkuRepository;
import com.quickmall.productservice.serivce.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuRepository skuRepository;

    @Override
    public PmsSkuResponse saveSkuInfo(PmsSkuRequest skuRequest) {

        PmsSku pmsSku = PmsSku.builder()
                .skuName(skuRequest.getSkuName())
                .spuId(skuRequest.getSpuId())
                .brandId(skuRequest.getBrandId())
                .categoryId(skuRequest.getCategoryId())
                .price(skuRequest.getPrice())
                .saleCount(skuRequest.getSaleCount())
                .skuStock(skuRequest.getSkuStock())
                .skuDefaultImage("https://developers.google.com/static/shopping-content/images/googlet.png")
                .skuTitle(skuRequest.getSkuTitle())
                .skuSubTitle(skuRequest.getSkuSubTitle())
                .skuDescription(skuRequest.getSkuDescription())
                .createTime(new Date())
                .build();

        skuRepository.save(pmsSku);

        PmsSkuResponse skuResponse = new PmsSkuResponse();

        copyProperties(pmsSku, skuResponse);

        return skuResponse;
    }

    @Override
    public List<PmsSku> getAllSkuInfo() {
        return skuRepository.findAll();
    }

    @Override
    public PmsSkuResponse getSkuById(Long skuId) {

        PmsSku pmsSku = skuRepository.findById(skuId)
                .orElseThrow(() -> new BasicServiceException(
                        "SkuId - " + skuId + "does not exist!",
                        "SKU_NOT_FOUND"
                ));

        PmsSkuResponse skuResponse = new PmsSkuResponse();
        copyProperties(pmsSku, skuResponse);

        return skuResponse;
    }

    @Override
    public void deleteSpuById(Long skuId) {
        skuRepository.deleteById(skuId);
    }
}
