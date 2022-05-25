package com.alibaba.taobao.model.dao;

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
    @Column(name = "create_time")
    private Date createTime;

    // 更新时间
    @Column(name = "update_time")
    private Date updateTime;


}
