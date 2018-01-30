package com.example.bootweb.autoconfig;

import com.example.bootweb.service.DemoService;
import com.example.bootweb.service.RoleService;
import com.example.bootweb.service.TeacherService;
import com.jtl.pojo.Bike;
import com.jtl.pojo.Car;
import com.jtl.pojo.Teacher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jiangtenglong no 2018/1/7 .
 */
@Configuration
//@ConditionalOnBean(TeacherService.class)
public class AutoconfigDemo {


    @Bean
    @ConditionalOnBean(DemoService.class)
//    @ConditionalOnBean(TeacherService.class)
    public Bike geBike(){
        Bike bike =  new Bike();
        bike.setName("双枪");
        return bike;
    }

    @Bean
    @ConditionalOnBean(TeacherService.class)
//    @ConditionalOnBean(RoleService.class)
    public Bike geBike1(){
        Bike bike =  new Bike();
        bike.setName("三枪");
        return bike;
    }

    @PostConstruct
    public void cons(){
        System.out.println("AutoconfigCar 创建完毕调用");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("AutoconfigCar 销毁前调用");
    }

}
