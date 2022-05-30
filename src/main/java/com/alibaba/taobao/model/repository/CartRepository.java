package com.alibaba.taobao.model.repository;

import com.alibaba.taobao.model.dao.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
