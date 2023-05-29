package com.quickmall.productservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsAttriGroupResponse {

    private Long attributeGroupId;

    private Long categoryId;

    private String attributeGroupName;

    private Integer sort;

    private String description;

    private String icon;

}
