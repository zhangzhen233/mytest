package com.itheima.controller;

import com.itheima.entity.PageBean;
import com.itheima.entity.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Product> list = productService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-list");
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/toUpdate")
    public ModelAndView save(Integer id) {
        Product product = productService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-update");
        mv.addObject("product", product);
        return mv;
    }

    @RequestMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delete")
    public String delete(String productIds) {
        productService.delete(productIds);
        return "redirect:/product/findAll";
    }

    @RequestMapping("findByPage")
    public ModelAndView findByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize
    ) {
        PageBean<Product> pageBean = productService.findByPage(pageNum,pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-list");
        mv.addObject("pageBean",pageBean);
        return mv;
    }
}
