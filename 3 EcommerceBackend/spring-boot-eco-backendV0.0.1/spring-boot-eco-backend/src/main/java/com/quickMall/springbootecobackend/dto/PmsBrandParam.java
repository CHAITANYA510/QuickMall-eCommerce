package com.quickMall.springbootecobackend.dto;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EqualsAndHashCode
public class PmsBrandParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long brandId;

    @Column(name = "brandName")
    private String name;

    @Column(name = "BrandFirstChar")
    private String firstLetter;

    @Column(name = "sortingVal")
    private Integer sort;

    @Column(name = "ifitsProductSupplier")
    private Integer factoryStatus;

    @Column(name = "ifDisplay")
    private Integer showStatus;

    @Column(name = "brandLogo")
    private String logo;

    @Column(name = "brandPic")
    private String bigPic;

    @Column(name = "brandStory")
    private String brandStory;

}
