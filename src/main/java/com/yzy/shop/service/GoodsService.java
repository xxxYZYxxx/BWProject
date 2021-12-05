package com.yzy.shop.service;

import com.yzy.shop.pojo.Brand;
import com.yzy.shop.pojo.Cate;
import com.yzy.shop.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface GoodsService {

    List<Goods> getGoodsList(HashMap<Object, Object> hashMap);

    List<Brand> getBrandList();

    List<Cate> getCateList();

    Integer addGoods(Goods goods);

    Integer getCount();

    boolean deleteGoods(Integer gid);

    List<Goods> getCertainGoodsList(@Param("goodsName")String goodsName,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
}
