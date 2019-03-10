package com.zdy.biz.order.listener;

import com.zdy.biz.order.model.LimitOrder;
import com.zdy.biz.order.model.MarketOrder;
import com.zdy.biz.order.model.OrderParam;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


@Component
public class MarketListener extends PlaceOrdersListener {

    @Override
    public boolean supportsSourceType(Class<?> clazz) {
        return  clazz == MarketOrder.class;
    }

    @Override
    public void verification(OrderParam order) {
        System.out.println("MarketListener=======" + order.getType());
    }
}
