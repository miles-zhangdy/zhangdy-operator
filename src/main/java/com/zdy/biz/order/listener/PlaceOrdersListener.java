package com.zdy.biz.order.listener;

import com.zdy.biz.order.event.OrderEvent;
import com.zdy.biz.order.model.OrderParam;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

public abstract class PlaceOrdersListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderEvent.class;
    }

    @Override
    public abstract boolean supportsSourceType(Class<?> var1);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderParam order = getEntrust(applicationEvent.getSource());
        verification(order);
    }

    public abstract void verification(OrderParam order);


    protected OrderParam getEntrust(Object source) {
        return (OrderParam) source;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
