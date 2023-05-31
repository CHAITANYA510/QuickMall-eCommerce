package com.quickmall.productservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsAttriGroupResponse {

    private Long attributeGroupId;

    private String attributeGroupName;

    private Long categoryId;

    private Integer sort;

}
