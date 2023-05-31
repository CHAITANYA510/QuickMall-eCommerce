package com.quickmall.productservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsAttriGroupRelationRequest {

    private Long attributeGroupRelationId;

    private Long attributeGroupId;

    private Long attributeId;

    private Integer attributeSort;

}
