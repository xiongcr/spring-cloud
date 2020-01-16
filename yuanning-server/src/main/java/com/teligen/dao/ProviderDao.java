package com.teligen.dao;

import com.teligen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

/**
 * Spring Data Jpa同样提供了类似Hibernated 的Criteria的查询方式，要使用这种方式只要继承 JpaSpecificationExecutor,该接口通过Specification来定义查询条件
 */
public interface ProviderDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    //方法名称必须要遵循驼峰式命名规则，findBy（关键字）+属性名称（首字母大写）+查询条件（首字母大写
    User findByUsername(String username);

    //自定义查询语句,原生查询，表名和字段名和数据库一样，不要用映射类的字段名
    @Query(value = "update user set logincount=?,lastlogintime=? where id=?", nativeQuery = true)
    @Modifying
    void updateLogincountAndLastlogintimeById(Integer logincount, Timestamp lastlogintime, Long id);

}
