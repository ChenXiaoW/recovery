package com.example.recovery.vo;

import com.example.recovery.pojo.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: OrderVO
 * @Description: OrderVO
 * @Author ChenXiaoW
 * @Date 2023/04/23 - 10:24
 */
@Data
public class OrderVO extends Order {

    @ApiModelProperty("预约人名称")
    private String purchaserName;

    @ApiModelProperty("创建人名称")
    private String createByName;

    @ApiModelProperty("更新人名称")
    private String updateByName;

    @ApiModelProperty("分类列表")
    private List<String> categoryNames;
}
