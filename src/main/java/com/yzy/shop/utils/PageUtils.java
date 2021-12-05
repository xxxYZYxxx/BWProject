package com.yzy.shop.utils;

import org.springframework.stereotype.Component;

@Component
public class PageUtils {

    //当前页
    private String currentPage;

    //上一页
    private Integer prevPage;

    //下一页
    private Integer nextPage;

    //尾页(也可以表示总页数)
    private Integer lastPage;

    //总记录条数
    private Integer count;

    //起始索引位置
    private Integer startIndex;

    //分页单位
    private Integer pageSize;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //计算上一页的值
    public void initPrevPage(){

        prevPage = currentPage.equals("1") ? 1 : Integer.parseInt(currentPage) - 1;
    }

    //计算尾页的值
    public void initLastPage(){

        lastPage = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
    }

    //计算下一页的值
    public void initNextPage(){

        nextPage = currentPage.equals(lastPage+"") ? lastPage : Integer.parseInt(currentPage) + 1;
    }

    //计算起始索引位置
    public void initStartIndex(){

        startIndex = (Integer.parseInt(currentPage) - 1) * pageSize;
    }


    //初始化的方法
    public void init(String currentPage,Integer pageSize,Integer count){

        if (currentPage == null || currentPage.equals("")){

            currentPage = "1";

        }

        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.count = count;

    }

    //调用的方法
    public void initPage(String currentPage,Integer pageSize,Integer count){

        init(currentPage,pageSize,count);
        initStartIndex();
        initPrevPage();
        initLastPage();
        initNextPage();

    }


}
