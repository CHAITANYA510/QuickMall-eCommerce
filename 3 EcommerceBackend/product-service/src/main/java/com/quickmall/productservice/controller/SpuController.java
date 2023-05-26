package com.quickmall.productservice.controller;

import com.quickmall.productservice.entity.PmsSpu;
import com.quickmall.productservice.model.PmsSpuRequest;
import com.quickmall.productservice.model.PmsSpuResponse;
import com.quickmall.productservice.serivce.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/spu")
@RestController
@Log4j2
@Api(tags = "SpuInfo")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @PostMapping()
    @ApiOperation("save Spu Information")
    public ResponseEntity<PmsSpuResponse> saveSpuInfo(@RequestBody PmsSpuRequest pmsSpuRequest) {
        var spuResponse = spuService.saveSpu(pmsSpuRequest);
        return new ResponseEntity<>(spuResponse, HttpStatus.CREATED);

    }

    @GetMapping
    @ApiOperation("get the Spu List")
    public List<PmsSpu> getAllSpuInfo() {
        return spuService.getAllSpu();
    }

    @GetMapping("/{spuId}")
    @ApiOperation("find the spu product by spuId")
    public ResponseEntity<PmsSpuResponse> getSpuById(@PathVariable("spuId") Long spuId) {
        PmsSpuResponse pmsSpuResponse = spuService.getSpuById(spuId);
        return new ResponseEntity<>(pmsSpuResponse, HttpStatus.ACCEPTED);
    }
}
