package com.itheima.entity;

import java.util.List;

public class PageBean<T> {
    //当前页
    private int pageNum;
    //页大小
    private int pageSize=5;
    //总记录数
    private long totalCount;
    //总页数
    private int totalPage;
    //当前页数据
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount(long count) {
        return totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalPage(){
        return (int) (totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1);
    }
}
