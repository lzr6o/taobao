package com.alibaba.taobao.model.repository;

import com.alibaba.taobao.model.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "insert into product (name, image, detail, price, stock) VALUES (:#{#product.name}, :#{#product.image}, :#{#product.detail}, :#{#product.price}), :#{#product.stock})", nativeQuery = true)
    int insertSelective(@Param("product") Product product);
}
