package com.example.recovery.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PageQuery
 * @Description: PageQuery
 * @Author  
 * @Date 2023/03/11 - 12:05
 */
@Data
public class PageQuery {

    @ApiModelProperty("当前页，默认1")
    private Integer current = 1;
    @ApiModelProperty("每页大小，默认10")
    private Integer size = 10;
}
