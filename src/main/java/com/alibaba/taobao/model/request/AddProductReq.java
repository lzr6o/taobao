package com.alibaba.taobao.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddProductReq {

    // 商品名称
    @NotNull(message = "商品名称不能为null")
    private String name;

    // 产品图片路径地址
    @NotNull(message = "商品图片不能为null")
    private String image;

    // 商品详情
    private String detail;

    // 价格，单位-分
    @NotNull(message = "商品价格不能为null")
    @Min(value = 1, message = "价格不能小于1分")
    private int price;

    // 库存数量
    @NotNull(message = "商品库存不能为null")
    @Max(value = 10000, message = "库存不能大于10000")
    private int stock;

    // 商品上架状态：0-下架，1-上架
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStatus() {
        return status;
    }

}
