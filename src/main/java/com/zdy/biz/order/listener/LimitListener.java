package com.zdy.biz.order.listener;

import com.zdy.biz.order.model.LimitOrder;
import com.zdy.biz.order.model.OrderParam;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


@Component
public class LimitListener extends PlaceOrdersListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> clazz) {
        return super.supportsEventType(clazz);
    }

    @Override
    public boolean supportsSourceType(Class<?> clazz) {
        return  clazz == LimitOrder.class;
    }

    @Override
    public void verification(OrderParam order) {
        System.out.println("LimitListener=======" + order.getType());
    }
}
