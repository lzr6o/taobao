package com.alibaba.taobao.model.repository;

import com.alibaba.taobao.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("select u from User u where u.username = :#{username} and u.password = :#{password}")
    User selectLogin(@Param("username") String username, @Param("password") String password);

    @Modifying
    @Query("update User u set u.personalizedSignature = :signature where u.id = :#{user.id}")
    int updateByPrimaryKeySelective(@Param("user") User user);
}
