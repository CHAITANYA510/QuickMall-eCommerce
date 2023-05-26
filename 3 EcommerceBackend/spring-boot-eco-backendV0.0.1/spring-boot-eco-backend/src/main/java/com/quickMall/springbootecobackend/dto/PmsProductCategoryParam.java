package com.quickMall.springbootecobackend.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PmsProductCategoryParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PmsProductCategoryParamId;

//    @ApiModelProperty("父分类的编号")
    private Long parentId;

//    @NotEmpty
//    @ApiModelProperty(value = "商品分类名称",required = true)
    private String name;

//    @ApiModelProperty("分类单位")
    private String productUnit;

//    @FlagValidator(value = {"0","1"},message = "状态只能为0或1")
//    @ApiModelProperty("是否在导航栏显示")
    private Integer navStatus;

//    @FlagValidator(value = {"0","1"},message = "状态只能为0或1")
//    @ApiModelProperty("是否进行显示")
    private Integer showStatus;

//    @Min(value = 0)
//    @ApiModelProperty("排序")
    private Integer sort;

//    @ApiModelProperty("图标")
    private String icon;

//    @ApiModelProperty("关键字")
    private String keywords;

//    @ApiModelProperty("描述")
    private String description;

    @ElementCollection
//    @ApiModelProperty("产品相关筛选属性集合")
    private List<Long> productAttributeIdList;


}
