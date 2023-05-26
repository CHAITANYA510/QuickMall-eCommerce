package com.quickMall.springbootecobackend.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsProductAttributeParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productAttributeCategoryId;

    @Column(name = "attributeName")
    private String attributeName;

    @Column(name = "attributeSelectingType")
    private Integer selectType;

    @Column(name = "attributeInputType")
    private Integer inputType;

    @Column(name = "inputList")
    private String inputList;

    @Column(name = "attributeSorting")
    private Integer sort;

    @Column(name = "filterType")
    private Integer filterType;

//    @ApiModelProperty("检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
//    @FlagValidator({"0","1","2"})
    @Column(name = "searchType")
    private Integer searchType;

//    @ApiModelProperty("相同属性产品是否关联；0->不关联；1->关联")
//    @FlagValidator({"0","1"})
    @Column(name = "similarAttriRelatedStatus")
    private Integer relatedStatus;

    @Column(name = "supportHandAddStatus")
//    @ApiModelProperty("是否支持手动新增；0->不支持；1->支持")
//    @FlagValidator({"0","1"})
    private Integer handAddStatus;

    @Column(name = "AttributeType")
//    @ApiModelProperty("属性的类型；0->规格；1->参数")
//    @FlagValidator({"0","1"})
    private Integer type;

}
