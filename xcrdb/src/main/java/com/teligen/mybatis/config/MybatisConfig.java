package com.teligen.mybatis.config;


import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MybatisConfig {

    public static SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource")DataSource dataSource)throws Exception{
        SqlSessionFactoryBean factory=new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        factory.setTypeAliasesPackage("");
        factory.setTypeHandlersPackage("");
        PageHelper pageHelper=new PageHelper();
        Properties properties=new Properties();
        properties.setProperty("dialect","Mysql");
        properties.setProperty("pageSizeZero","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("supportMethodArguments","true");
        pageHelper.setProperties(properties);

        factory.setPlugins(new Interceptor[]{pageHelper});
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();

        SqlSessionFactory sessionFactory=factory.getObject();
        sessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        return sessionFactory;
    }


    public static MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("com.teligen.mybatis.mapper");
        Properties properties=new Properties();
        properties.setProperty("mappers","com.teligen.mabatis.ImacMapper");
        properties.setProperty("notEmpty","false");
        properties.setProperty("IDENTITY","MYSQL");
        properties.setProperty("ORDER","BEFORE");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }



}
