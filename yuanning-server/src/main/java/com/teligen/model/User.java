package com.teligen.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user")//唯一索引字段
public class User {
    /*
    TABLE： 使用一个特定的数据库表格来保存主键
    SEQUENCE： 根据底层数据库的序列来生成主键，条件是数据库支持序列。这个值要与generator一起使用，generator 指定生成主键使用的生成器（可能是orcale中自己编写的序列）
    IDENTITY： 主键由数据库自动生成（主要是支持自动增长的数据库，如mysql）
    AUTO： 主键由程序控制，也是GenerationType的默认值
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Integer logincount;
    private Timestamp lastlogintime;
    private Timestamp createtime;
    private Timestamp updatetime;
    private String loginip;
/*  @Transient  此注解标注的字段和数据库字段不映射
    private String note;*/
}