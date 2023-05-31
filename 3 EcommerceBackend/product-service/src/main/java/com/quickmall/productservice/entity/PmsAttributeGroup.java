package com.quickmall.productservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class PmsAttributeGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attributeGroupId;

    private String attributeGroupName;

    private Long categoryId;

    private Integer sort;

}
