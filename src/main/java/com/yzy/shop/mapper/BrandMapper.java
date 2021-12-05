package com.yzy.shop.mapper;

import com.yzy.shop.pojo.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {
    /**
     * 查询品牌数据
     * @return
     */
    List<Brand> getBrandList();
}
