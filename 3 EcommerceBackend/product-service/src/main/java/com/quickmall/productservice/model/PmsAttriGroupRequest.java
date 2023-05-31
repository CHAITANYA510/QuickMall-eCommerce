package com.quickmall.productservice.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class PmsAttriGroupRequest implements Serializable {

    private Long attributeGroupId;

    private String attributeGroupName;

    private Long categoryId;

    private Integer sort;

}
