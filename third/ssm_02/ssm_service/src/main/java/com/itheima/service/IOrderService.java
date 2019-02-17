package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.entity.Order;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();

    /*
    * 分页查询
    * */
    PageInfo<Order> findByPage(int pageNum,int pageSize);
}
