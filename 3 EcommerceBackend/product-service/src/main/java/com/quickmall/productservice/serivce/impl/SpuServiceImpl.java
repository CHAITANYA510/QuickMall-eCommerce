package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsSpu;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsSpuRequest;
import com.quickmall.productservice.model.PmsSpuResponse;
import com.quickmall.productservice.repository.SkuRepository;
import com.quickmall.productservice.repository.SpuRepository;
import com.quickmall.productservice.serivce.SpuService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuRepository spuRepository;

    @Autowired
    private SkuRepository skuRepository;


    @Override
    public PmsSpuResponse saveSpu(PmsSpuRequest pmsSpuRequest) {
        PmsSpu pmsSpu = PmsSpu.builder()
                .categoryId(pmsSpuRequest.getCategoryId())
                .brandId(pmsSpuRequest.getBrandId())
                .brandName(pmsSpuRequest.getBrandName())
                .publishStatus(pmsSpuRequest.getPublishStatus())
                .spuName(pmsSpuRequest.getSpuName())
                .spuDescription(pmsSpuRequest.getSpuDescription())
                .createTime(new Date())
                .updateTime(new Date())
                .build();

        spuRepository.save(pmsSpu);
        PmsSpuResponse pmsSpuResponse = new PmsSpuResponse();
        copyProperties(pmsSpu, pmsSpuResponse);

        return pmsSpuResponse;
    }


    @Override
    public List<PmsSpu> getAllSpu() {
        return spuRepository.findAll();
    }

    @Override
    public PmsSpuResponse getSpuById(Long spuId) {
        PmsSpu pmsSpu = spuRepository.findById(spuId)
                .orElseThrow(() -> new BasicServiceException(
                        "spu product - " + spuId + " does not exist!",
                        "SPU_PRODUCT_NOT_FOUND"
                ));

        PmsSpuResponse pmsSpuResponse = new PmsSpuResponse();
        copyProperties(pmsSpu, pmsSpuResponse);

        return pmsSpuResponse;
    }

    /**
     * get spu via skuId
     * @param skuId
     * @return
     */
    @Override
    public PmsSpuResponse getSpuBySkuId(Long skuId) {

        Long spuId = skuRepository.findById(skuId).get().getSpuId();
        PmsSpu spu = spuRepository.findById(spuId).get();

        PmsSpuResponse spuResponse = new PmsSpuResponse();
        copyProperties(spu, spuResponse);

        log.info("Get SpuInfo via SkuId: " + spu);

        return spuResponse;
    }

    @Override
    public void deleteSpuById(Long spuId) {
        spuRepository.deleteById(spuId);
    }
}
