package com.alibaba.taobao.model.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    // 商品主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "product_id")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "product_id")
    private List<Cart> carts = new ArrayList<>();

    // 商品名称
    @Column(name = "name")
    private String name;

    // 产品图片路径地址
    @Column(name = "image")
    private String image;

    // 商品详情
    @Column(name = "detail")
    private String detail;

    // 价格，单位-分
    @Column(name = "price")
    private int price;

    // 库存数量
    @Column(name = "stock")
    private int stock;

    // 商品上架状态：0-下架，1-上架
    @Column(name = "status")
    private int status;

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


}
