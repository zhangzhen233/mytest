package com.itheima.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.itheima.dao.IProductDao;
import com.itheima.entity.PageBean;
import com.itheima.entity.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IProductImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void delete(String productIds) {
        if (!StringUtils.isEmpty(productIds)){
            String[] array = productIds.split(",");
            if (array != null && array.length>0){
                for (String id : array){
                    productDao.delete(id);
                }
            }
        }
    }

    public PageBean<Product> findByPage(int pageNum, int pageSize) {
        if (pageNum<1){
            pageNum=1;
        }
        long count = productDao.count();
        List<Product> list = productDao.findByPage(pageNum*pageSize,(pageNum - 1)*pageSize);
        PageBean<Product> pageBean = new PageBean<Product>();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);
        pageBean.getTotalCount(count);
        pageBean.setList(list);
        return pageBean;
    }
}
