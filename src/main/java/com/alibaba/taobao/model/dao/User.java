package com.alibaba.taobao.model.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    // 用户id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders = new ArrayList<>();

    // 用户名
    @Column(name = "username")
    private String username;

    // 用户密码，MD5加密
    @Column(name = "password")
    private String password;

    // 个性签名
    @Column(name="personalized_signature")
    private String personalizedSignature;

    // 角色，1-普通用户，2-管理员
    @Column(name = "role")
    private Long role;

    // 创建时间
    @Column(name = "create_time")
    private Date createTime;

    // 更新时间
    @Column(name = "update_time")
    private Date updateTime;

    public User() {

    }


}
