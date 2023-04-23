package com.example.recovery.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author 
 * @since 2023-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
    private Date pickUpTime;

    /**
     * 预估重量(KG)
     */
    @ApiModelProperty("预估重量(KG)")
    private String estimateWeight;

    /**
     * 订单状态：-1(已取消)，0(已下单)，1-已完成
     */
    @ApiModelProperty("订单状态：-1(已取消)，0(已下单)，1-已完成")
    private Integer state;

    /**
     * 完成时间
     */
    @ApiModelProperty("完成时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date finishTime;

    /**
     * 创建人ID
     */
    @ApiModelProperty("创建人ID")
    private Integer createBy;

    /**
     * 更新人ID
     */
    @ApiModelProperty("更新人ID")
    private Integer updateBy;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 删除标记：0-否，1-是
     */
    @JsonIgnore
    @ApiModelProperty("删除标记：0-否，1-是")
    @TableLogic
    private Boolean delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
