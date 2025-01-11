package com.xworkz.module.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import javax.sql.DataSource;


@Configuration
@ComponentScan("com.xworkz.module")
@EnableWebMvc
@Slf4j
public class ModuleConfiguration {

    private int sizeOfImg=10*1024*1024;
    public ModuleConfiguration(){
        System.out.println("Running No-arg const in ModuleConfiguration");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        log.info("this is hp laptop");
        bean.setPackagesToScan("com.xworkz.module.entity");
        bean.setDataSource(datasource());
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return bean;
    }


    @Bean
    public DataSource datasource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/xworkz_details");
        dataSource.setUsername("root");
        dataSource.setPassword("Xworkzodc@123");
        return dataSource;
    }
    @Bean
    public ViewResolver onView(){
        return new InternalResourceViewResolver("/",".jsp");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(sizeOfImg);
        commonsMultipartResolver.setMaxInMemorySize(sizeOfImg);
        return commonsMultipartResolver;
    }

}

