package com.alibaba.taobao.model.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    // 主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 订单号（非主键id）
    @Column(name = "order_no")
    private String orderNo;

    // 订单总价格
    @Column(name = "totol_price")
    private int totalPrice;

    // 收货人姓名快照
    @Column(name = "receiver_name")
    private String receiverName;

    // 收货人手机号快照
    @Column(name = "receiver_mobile")
    private String receiverMobile;

    // 收货地址快照
    @Column(name = "receiver_address")
    private String receiverAddress;

    // 订单状态：0用户已取消，10未付款（初始状态），20已付款，30已发货，40交易完成
    @Column(name = "order_status")
    private int orderStatus;

    // 运费，默认为0
    @Column(name = "postage")
    private int postage;

    // 支付类型，1-在线支付
    @Column(name = "payment_type")
    private int paymentType;

    // 发货时间
    @Column(name = "delivery_time")
    private Date deliveryTime;

    // 支付时间
    @Column(name = "pay_time")
    private Date payTime;

    // 交易完成时间
    @Column(name = "end_time")
    private Date endTime;

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
