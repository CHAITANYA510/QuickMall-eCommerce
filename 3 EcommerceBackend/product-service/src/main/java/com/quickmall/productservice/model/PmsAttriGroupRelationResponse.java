package com.quickmall.productservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsAttriGroupRelationResponse {

    private Long attributeGroupRelationId;

    private Long attributeId;

    private Long attributeGroupId;

//    private Integer attributeSort;

}
