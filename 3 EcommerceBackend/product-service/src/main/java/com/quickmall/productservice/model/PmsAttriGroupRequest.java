package com.quickmall.productservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsAttriGroupRequest implements Serializable {

    private Long attributeGroupId;

    private Long categoryId;

    private String attributeGroupName;

    private Integer sort;

    private String description;

    private String icon;

}
