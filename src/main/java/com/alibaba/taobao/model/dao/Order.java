package com.alibaba.taobao.model.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "\"Order\"")
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

    public Order() {

    }

    public Order(int id, User user, String orderNo, int totalPrice, String receiverName, String receiverMobile, String receiverAddress, int orderStatus, int postage, int paymentType, Date deliveryTime, Date payTime, Date endTime, Date createTime, Date updateTime) {
        this.id = id;
        this.user = user;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.receiverName = receiverName;
        this.receiverMobile = receiverMobile;
        this.receiverAddress = receiverAddress;
        this.orderStatus = orderStatus;
        this.postage = postage;
        this.paymentType = paymentType;
        this.deliveryTime = deliveryTime;
        this.payTime = payTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPostage() {
        return postage;
    }

    public void setPostage(int postage) {
        this.postage = postage;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", orderNo='" + orderNo + '\'' +
                ", totalPrice=" + totalPrice +
                ", receiverName='" + receiverName + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", orderStatus=" + orderStatus +
                ", postage=" + postage +
                ", paymentType=" + paymentType +
                ", deliveryTime=" + deliveryTime +
                ", payTime=" + payTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
