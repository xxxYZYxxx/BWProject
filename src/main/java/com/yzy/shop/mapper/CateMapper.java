package com.yzy.shop.mapper;

import com.yzy.shop.pojo.Cate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CateMapper {
    /**
     * 查询类别数据
     * @return
     */
    List<Cate> getCateList();
}
