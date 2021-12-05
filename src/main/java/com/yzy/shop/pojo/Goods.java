package com.yzy.shop.pojo;

public class Goods {
    private Integer gid;
    private String goodsName;
    private Double price;
    private String upTime;
    private Integer brandId;
    private Integer cateId;
    private String goodsDesc;
    private Integer num;

    public Goods(Integer gid, String goodsName, Double price, String upTime, Integer brandId, Integer cateId, String goodsDesc, Integer num) {
        this.gid = gid;
        this.goodsName = goodsName;
        this.price = price;
        this.upTime = upTime;
        this.brandId = brandId;
        this.cateId = cateId;
        this.goodsDesc = goodsDesc;
        this.num = num;
    }

    public Goods() {
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", upTime='" + upTime + '\'' +
                ", brandId=" + brandId +
                ", cateId=" + cateId +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", num=" + num +
                '}';
    }
}
