package com.alibaba.taobao.model.repository;

import com.alibaba.taobao.model.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updataByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
