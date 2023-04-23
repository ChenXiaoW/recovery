package com.example.recovery.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单关联分类表
 * </p>
 *
 * @author 
 * @since 2023-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order_relate_category")
public class OrderRelateCategory extends Model<OrderRelateCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标记：0-否，1-是
     */
    private Boolean delFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
