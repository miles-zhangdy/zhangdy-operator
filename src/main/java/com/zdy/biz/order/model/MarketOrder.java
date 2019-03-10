package com.zdy.biz.order.model;

import com.zdy.common.enums.OrderType;

public class MarketOrder extends OrderParam {

    public MarketOrder(String id, OrderType type){
        super(id, type);
    }

}
