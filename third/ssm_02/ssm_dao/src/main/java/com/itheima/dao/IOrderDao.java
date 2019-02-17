package com.itheima.dao;

import com.itheima.entity.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderDao {
    @Select("select o.*,p.id,p.productnum,p.productname,p.cityname,p.productprice from orders o inner join product p on o.productid=p.id")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "product.id",column = "pid"),
            @Result(property = "product.productNum",column = "productnum"),
            @Result(property = "product.productName",column = "productname"),
            @Result(property = "product.cityName",column = "cityname"),
            @Result(property = "product.productPrice",column = "productprice")
    })
    List<Order> findAll();
}
