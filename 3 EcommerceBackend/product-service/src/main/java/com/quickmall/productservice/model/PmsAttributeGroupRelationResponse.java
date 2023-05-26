package com.quickmall.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsAttributeGroupRelationResponse {

    private Long attributeGroupRelationId;

    private Long attributeId;

    private Long attributeGroupId;

    private Integer attributeSort;

}
