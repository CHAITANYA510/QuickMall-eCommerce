package com.quickmall.productservice.serivce.impl;

import com.quickmall.productservice.entity.PmsSpu;
import com.quickmall.productservice.exception.BasicServiceException;
import com.quickmall.productservice.model.PmsSpuRequest;
import com.quickmall.productservice.model.PmsSpuResponse;
import com.quickmall.productservice.repository.SpuRepository;
import com.quickmall.productservice.serivce.SpuService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuRepository spuRepository;


    @Override
    public PmsSpuResponse saveSpu(PmsSpuRequest pmsSpuRequest) {
//        spuRepository.save(pmsSpuRequest);
        PmsSpu pmsSpu = PmsSpu.builder()
                .spuId(pmsSpuRequest.getSpuId())
                .categoryId(pmsSpuRequest.getCategoryId())
                .brandId(pmsSpuRequest.getBrandId())
                .spuName(pmsSpuRequest.getSpuName())
                .spuDescription(pmsSpuRequest.getSpuDescription())
                .brandName(pmsSpuRequest.getBrandName())
                .weight(pmsSpuRequest.getWeight())
                .createTime(new Date())
                .updateTime(new Date())
                .spuApprovedStatus(pmsSpuRequest.getSpuApprovedStatus())
                .publishStatus(pmsSpuRequest.getPublishStatus())
                .build();

        spuRepository.save(pmsSpu);
        PmsSpuResponse pmsSpuResponse = new PmsSpuResponse();
        copyProperties(pmsSpu, pmsSpuResponse);

        return pmsSpuResponse;
    }


    @Override
    public List<PmsSpu> getAllSpu() {
        List<PmsSpu> pmsSpuList = spuRepository.findAll();

//        List<PmsSpuResponse> pmsSpuResponseList = new ArrayList<>();

//        copyProperties(pmsSpuList, pmsSpuResponseList);
        return pmsSpuList;
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
}
