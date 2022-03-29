package com.yzy.shop.service.impl;

import com.yzy.shop.mapper.BrandMapper;
import com.yzy.shop.mapper.CateMapper;
import com.yzy.shop.mapper.GoodsMapper;
import com.yzy.shop.pojo.Brand;
import com.yzy.shop.pojo.Cate;
import com.yzy.shop.pojo.Goods;
import com.yzy.shop.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CateMapper cateMapper;
    /**
     * 实现商品列表
     * @return
     */
    @Override
    public List<Goods> getGoodsList(HashMap<Object, Object> hashMap) {
        return goodsMapper.getGoodsList(hashMap);
    }

    @Override
    public List<Brand> getBrandList() {
        return brandMapper.getBrandList();
    }

    @Override
    public List<Cate> getCateList() {
        return cateMapper.getCateList();
    }

    /**
     * 1、如果商品存在,则库存加一
     * 2、如果商品不存在，正常的执行添加
     * @param goods
     * @return
     */
    @Override
    public Integer addGoods(Goods goods) {
        if (goods.getGoodsName() != null){

            //去数据库中校验商品是否存在
            Goods g = goodsMapper.findGoodsByName(goods.getGoodsName());

            if (g != null){

                //库存加一
                if (goodsMapper.addNum(g.getGid())){

                    return 1;
                }

                return 2;

            }else {

                //获取当前系统的时间
                Date date = new Date();

                //创建日期格式化对象
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                //将日期格式化成日期字符串
                String upTime = simpleDateFormat.format(date);

                //将系统时间赋给goods实例
                goods.setUpTime(upTime);

                //将库存设置为1
                goods.setNum(1);

                System.out.println(goods);

                //执行添加
                if (goodsMapper.addGoods(goods)){

                    return 3;

                }

                return 2;

            }
        }

        return 2;
    }

    @Override
    public Integer getCount() {
        return goodsMapper.getCount();
    }

    @Override
    public boolean deleteGoods(Integer gid) {
        return goodsMapper.deleteGoods(gid);
    }

    @Override
    public List<Goods> getCertainGoodsList(@Param("goodsName") String goodsName,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize) {
        return goodsMapper.getCertainGoodsList(goodsName,startIndex,pageSize);
    }

    @Override
    public Integer addNum(Integer gid) {
        return goodsMapper.addNumButton(gid);
    }

    @Override
    public Integer subtractNum(Integer gid) {
        //查询库存数量
        int goodsCount=goodsMapper.getGoodsCount(gid);
        if(goodsCount>0){
            return goodsMapper.subtractNum(gid);
        }else{
            return 0;
        }
    }

    @Override
    public boolean deleteGoodsByIds(String ids) {
        String[] split = ids.split(",");
        List<String> strings = Arrays.asList(split);
        int num=goodsMapper.deleteGoodsByIds(strings);
        if(num>0){
            return true;
        }else{
            return false;
        }
    }


}
