package com.xyt.springcloud.service.impl;

import com.xyt.springcloud.dao.OrderDao;
import com.xyt.springcloud.domain.Order;
import com.xyt.springcloud.service.AccountService;
import com.xyt.springcloud.service.OrderService;
import com.xyt.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        System.out.println("---------------->开始新建订单");
        orderDao.create(order);
        System.out.println("---------------->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        System.out.println("---------------->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());

        //修改订单状态  从0到1
        System.out.println("------>修改订单状态开始");
        orderDao.update(order.getUserId(),0);

        System.out.println("---------------->下订单结束，(●ˇ∀ˇ●)");
    }
}
