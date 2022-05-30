package com.alibaba.taobao.model.repository;

import com.alibaba.taobao.model.dao.Order;
import com.alibaba.taobao.model.dao.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updataByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}
