package com.alibaba.taobao.model.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "selected")
    private int selected;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
