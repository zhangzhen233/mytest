package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.entity.Order;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Order> list = orderService.findAll();
        mv.setViewName("order-list");
        mv.addObject("list",list);
        return mv;
    }
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "2") int pageSize
    ){
        PageInfo<Order> pageInfo = orderService.findByPage(pageNum,pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("order-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
}
