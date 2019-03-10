package com.zdy.biz.order.model;

import com.zdy.common.enums.OrderType;

public class LimitOrder extends  OrderParam {

    public LimitOrder(String id, OrderType type){
        super(id, type);
    }

}
