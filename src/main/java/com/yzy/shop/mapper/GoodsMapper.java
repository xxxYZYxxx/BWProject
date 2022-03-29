package com.yzy.shop.mapper;

import com.yzy.shop.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface GoodsMapper {
    /**
     * 查询商品信息
     * @return
     */
    List<Goods> getGoodsList(HashMap<Object, Object> hashMap);

    Goods findGoodsByName(String goodsName);

    boolean addNum(Integer gid);

    boolean addGoods(Goods goods);

    Integer getCount();

    boolean deleteGoods(Integer gid);

    List<Goods> getCertainGoodsList(@Param("goodsName")String goodsName,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);

    Integer addNumButton(Integer gid);

    int getGoodsCount(Integer gid);

    Integer subtractNum(Integer gid);

    int deleteGoodsByIds(List<String> strings);
}
