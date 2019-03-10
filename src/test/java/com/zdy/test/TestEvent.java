package com.zdy.test;


import com.zdy.biz.order.event.OrderEvent;
import com.zdy.biz.order.model.LimitOrder;
import com.zdy.biz.order.model.MarketOrder;
import com.zdy.biz.order.model.OrderParam;
import com.zdy.common.enums.OrderType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestEvent {


    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testLimit(){

        OrderParam limitOrder = new LimitOrder("1", OrderType.LIMIT);
        applicationContext.publishEvent(new OrderEvent(limitOrder));
        System.out.println("######################");
        OrderParam marketOrder = new MarketOrder("1", OrderType.MARKET);
        applicationContext.publishEvent(new OrderEvent(marketOrder));

    }

}
