package com.alibaba.taobao.model.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_item")
public class OrderItem {

    // 主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // 归属订单id
    @Column(name = "order_no")
    private String orderNo;

    // 商品名称
    @Column(name = "product_name")
    private String productName;

    // 商品图片
    @Column(name = "product_img")
    private String productImg;

    // 单价（下单时的快照）
    @Column(name = "unit_price")
    private String unitPrice;

    // 商品数量
    @Column(name = "quantity")
    private int quantity;

    // 商品总价
    @Column(name = "total_price")
    private int totalPrice;

    // 创建时间
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

    // 更新时间
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

    public OrderItem() {

    }

    public OrderItem(int id, String orderNo, String productName, String productImg, String unitPrice, int quantity, int totalPrice, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.productImg = productImg;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", productName='" + productName + '\'' +
                ", productImg='" + productImg + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
