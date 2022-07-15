package com.alibaba.taobao.model.repository;

import com.alibaba.taobao.model.dao.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "insert into category (name, type, parent_id, order_num) VALUES (:#{#category.name}, :#{#category.type}, :#{#category.parentId}, :#{#category.orderNum})", nativeQuery = true)
    int insertSelective(@Param("category") Category category);
}
