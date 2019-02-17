package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.IOrderDao;
import com.itheima.entity.Order;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IOrederServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public PageInfo<Order> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> list = orderDao.findAll();
        return new PageInfo<Order>(list);
    }
}
