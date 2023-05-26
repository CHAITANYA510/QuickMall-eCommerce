package com.quickmall.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsSpuApprovedStatusResponse {

    private Long spuApprovedStatusId;

    private Long pmsSpuInfoId;

}
