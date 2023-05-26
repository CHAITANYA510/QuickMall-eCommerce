package com.quickmall.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsAttributeGroupResponse {

    private Long attributeGroupId;

    private Long categoryId;

    private String attributeGroupName;

    private Integer sort;

    private String description;

    private String icon;

    @ElementCollection
    private List<Long> categoryPath;

}
