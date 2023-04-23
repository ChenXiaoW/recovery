package com.example.recovery.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: OrderPageQuery
 * @Description: OrderPageQuery
 * @Author ChenXiaoW
 * @Date 2023/04/23 - 10:32
 */
@Data
public class OrderPageQuery extends PageQuery {

    @ApiModelProperty("联系人手机号")
    private String contactMobile;

    @ApiModelProperty("预约人姓名")
    private String purchaserName;

    @ApiModelProperty("订单状态：-1(已取消)，0(已下单)，1-已完成")
    private Integer state;
}
