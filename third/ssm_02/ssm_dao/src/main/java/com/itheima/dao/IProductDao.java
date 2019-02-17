package com.itheima.dao;

import com.itheima.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    List<Product> findAll();

    @Insert({"insert into product values(SEQ_PRODUCT.nextval,#{productNum},#{productName}," +
            "#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})"})
    void save(Product product);

    @Select("select * from product where id = #{id}")
    Product findById(Integer id);

    @Update("update product set productNum=#{productNum},productName=#{productName}" +
            ",cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice}," +
            "productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void update(Product product);

    @Delete("delete from product where id = #{id}")
    void delete(String id);

    @Select("select * from (\n"+"select p.*,rownum rn from product p where rownum <= #{index})\n"+"where rownum>#{count}")
    List<Product> findByPage(@Param("index") int index,@Param("count") int count);

    @Select("select count(1) from product")
    long count();
}
