package com.zdy.biz.order.model;

import com.zdy.common.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderParam {
    private String id;
    private OrderType type;
}
