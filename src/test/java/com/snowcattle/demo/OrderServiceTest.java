package com.snowcattle.demo;

import com.snowcattle.demo.entity.Order;
import com.snowcattle.demo.service.impl.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:db_applicationContext.xml")
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void insert(){
        for(int i = 0; i < 12; i++){
            Order order = new Order();
            order.setUserId(i);
            order.setOrderId(i);
            order.setStatus("测试插入");
            orderService.insertOrder(order);
        }
    }

    @Test
    public void delete(){
        orderService.deleteByUserId(0);
    }

    @Test
    public void update(){
        Order order = new Order();
        order.setUserId(2);
        order.setStatus("测试删除");
        orderService.updateOrder(order);
    }
    @Test
    public void select(){
        orderService.getOrderByUserId(2);
    }


}//end of class
