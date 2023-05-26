package com.quickmall.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class PmsAttributeGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attributeGroupId;

    private Long categoryId;

    private String attributeGroupName;

    private Integer sort;

    private String description;

    private String icon;

    @ElementCollection
    private List<Long> categoryPath;

}
