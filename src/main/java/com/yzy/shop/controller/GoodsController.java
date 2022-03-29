package com.yzy.shop.controller;

import com.yzy.shop.pojo.Brand;
import com.yzy.shop.pojo.Cate;
import com.yzy.shop.pojo.Goods;
import com.yzy.shop.service.GoodsService;
import com.yzy.shop.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource(name = "goodsService")
    private GoodsService goodsService;

    @Resource(name = "pageUtils")
    private PageUtils pageUtils;

    /**
     * 查询所有的品牌数据
     * @return
     */
    @RequestMapping("/findAllBrand")
    @ResponseBody
    public List<Brand> findAllBrand(){

        return goodsService.getBrandList();

    }

    /**
     * 跳转add页面
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(){

        return "GoodsAdd";

    }

    /**
     * 去往指定查询界面
     * @return
     */
    @RequestMapping("/toCertainList")
    public String toCertainList(){
        return "CertainGoodsList";
    }
    /**
     * 添加商品
     * 1、商品存在，库存添加成功,给前端返回 1
     * 2、商品存在，库存添加失败,给前端返回 2
     * 3、商品不存在，添加成功，给前端返回3
     * 4、商品不存在，添加失败，给前端返回2
     * @return
     */
    @RequestMapping("/addGoods")
    @ResponseBody
    public Integer addGoods(Goods goods){

        return goodsService.addGoods(goods);

    }

    /**
     * 删除商品
     * @param gid
     * @return
     */
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public boolean deleteGoods(Integer gid){
        System.out.println(gid);
        return goodsService.deleteGoods(gid);
    }

    /**
     * 给库存加一
     * @param gid
     * @return
     */
    @RequestMapping("/addNum")
    @ResponseBody
    public Integer addNum(Integer gid){
        return goodsService.addNum(gid);
    }

    /**
     * 给库存减1
     * @param gid
     * @return
     */
    @RequestMapping("/subtractNum")
    @ResponseBody
    public Integer subtractNum(Integer gid){
        return goodsService.subtractNum(gid);
    }

    /**
     * 实现商品列表
     * @param model
     * @return
     * currentPage 当前页的页码值
     */
    @RequestMapping("/list")
    public String getGoodsList(Model model,String currentPage){

        //创建一个map集合，用于存放数据
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();

        //调用分页工具类（20个数据一页）
        pageUtils.initPage(currentPage,20,goodsService.getCount());

        //将分页所需要的条件传到集合里
        hashMap.put("startIndex",pageUtils.getStartIndex());
        hashMap.put("pageSize",pageUtils.getPageSize());

        //查询商品数据
        List<Goods> goodsList = goodsService.getGoodsList(hashMap);

        //查询品牌数据
        List<Brand> brandList = goodsService.getBrandList();

        //查询类别的数据
        List<Cate> cateList = goodsService.getCateList();

        //将数据存到Model中
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("brandList",brandList);
        model.addAttribute("cateList",cateList);
        model.addAttribute("pageUtils",pageUtils);

        return "GoodsList";

    }

    /**
     * 模糊查询所得的商品列表
     * @param model
     * @param currentPage
     * @return
     */
    @RequestMapping("/certainlist")
    public String getCertainGoodsList(Model model,String currentPage,String goodsName){
        //调用分页工具类（20个数据一页）
        pageUtils.initPage(currentPage,20,goodsService.getCount());

        //查询商品数据
        List<Goods> goodsList = goodsService.getCertainGoodsList(goodsName,pageUtils.getStartIndex(), pageUtils.getPageSize());

        //查询品牌数据
        List<Brand> brandList = goodsService.getBrandList();

        //查询类别的数据
        List<Cate> cateList = goodsService.getCateList();

        //将数据存到Model中
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("brandList",brandList);
        model.addAttribute("cateList",cateList);
        model.addAttribute("pageUtils",pageUtils);

        return "CertainGoodsList";
    }


}
