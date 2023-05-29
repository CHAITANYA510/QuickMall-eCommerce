package com.quickmall.productservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsAttriGroupRelationRequest {

    private Long attributeGroupRelationId;

    private Long attributeId;

    private Long attributeGroupId;

//    private Integer attributeSort;

}
