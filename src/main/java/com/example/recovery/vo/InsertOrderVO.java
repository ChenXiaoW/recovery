package com.example.recovery.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: InsertOrderVO
 * @Description: InsertOrderVO
 * @Author ChenXiaoW
 * @Date 2023/04/23 - 10:43
 */
@Data
public class InsertOrderVO {


    /**
     * 购买人用户ID
     */
    @ApiModelProperty("购买人用户ID")
    private Integer purchaserId;

    /**
     * 联系人手机号
     */
    @ApiModelProperty("联系人手机号")
    private String contactMobile;

    /**
     * 省
     */
    @ApiModelProperty("省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty("市")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty("区")
    private String area;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 经度
     */
    @ApiModelProperty("经度")
    private String longitude;

    /**
     * 纬度
     */
    @ApiModelProperty("纬度")
    private String latitude;

    /**
     * 取件时间
     */
    @ApiModelProperty("取件时间")
    private String pickUpTime;

    /**
     * 预估重量(KG)
     */
    @ApiModelProperty("预估重量(KG)")
    private String estimateWeight;

    @ApiModelProperty("分类ID列表")
    private List<Integer> categoryIds;
}
