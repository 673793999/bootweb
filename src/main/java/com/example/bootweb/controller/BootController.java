package com.example.bootweb.controller;

import com.example.bootweb.mapper.RoleMapper;
import com.example.bootweb.peoperties.MyProperties;
import com.example.bootweb.peoperties.PropertiesDemo;
import com.example.bootweb.service.RoleService;
import com.example.bootweb.service.TeacherService;
import com.jtl.pojo.Bike;
import com.jtl.pojo.Car;
import com.jtl.pojo.Role;
import com.jtl.pojo.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangtenglong no 2018/1/6 .
 */
@RestController
@RequestMapping("/hello")
@EnableConfigurationProperties({PropertiesDemo.class})
public class BootController {

    Logger logger = LoggerFactory.getLogger(BootController.class);

    @Autowired
    TeacherService teacherService;

    @Autowired
    RoleService roleService;

    @Autowired
    MyProperties myProperties;

    @Autowired
    PropertiesDemo propertiesDemo;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    Bike bike;




    @RequestMapping("/helloBoot")
    public String hello(){
        return " my bike is"+bike.getName();
    }

    @RequestMapping("/add")
    public String add(Teacher teacher){
        teacherService.addTeacher(teacher);
        return "success";
    }

    @RequestMapping("/find")
    public Object find(String name){
        Teacher teache = new Teacher();
        teache.setName(name);
        Teacher teacher = teacherService.getTeacher(teache);
        return teacher;
    }

    @RequestMapping("/delete")
    public void delete(String name){
        teacherService.deleteTeacher(name);
    }


    @RequestMapping("/getrole")
    public Object getRoles(){
        return roleService.getRoleList();
    }

    @RequestMapping("/insertRole")
    public Object insert(Role role){
        roleService.insert(role);
        return "success";
    }

    @RequestMapping("/deletebyid")
    public Object insert(Long id){
        roleService.delete(id);
        return "success";
    }

    @RequestMapping("/setrolecache")
    public Object setRole(Role role){
        roleService.setRole(role);
        return "success";
    }

    @RequestMapping("/getrolecache")
    public Object getRole(String roleName){
        return roleService.getRole(roleName);
    }

    @RequestMapping("/setRoleStatus")
    public void setRoleStatus(String roleName,String status){
        roleService.setRoleStatus(roleName,status);
    }

    @RequestMapping("/getRoleStatus")
    public String getRoleStatus(String roleName){
        return roleService.getRoleStatus(roleName);
    }

    @RequestMapping("/setRoleStatusForString")
    public void setRoleStatusForString(String roleName,String status){
        roleService.setRoleStatusForString(roleName,status);
    }

    @RequestMapping("/getRoleStatusForString")
    public String getRoleStatusForString(String roleName){
        return roleService.getRoleStatusForString(roleName);
    }

    @RequestMapping("/setRoleStatusList")
    public String setRoleStatusList(String roleName,String code){
        Role role = new Role();
        role.setRoleName(roleName);
        role.setRoleCode(code);
        roleService.addCacheList(role);
        return "success";
    }

    @RequestMapping("/getRoleStatusList")
    public Object getRoleStatusList(){
        return roleService.getCacgeList();
    }

    @RequestMapping("/describe")
    public String getproperties(){
        return myProperties.getName();
    }

    @RequestMapping("/name")
    public String getname(){
        return propertiesDemo.getName();
    }


    @RequestMapping("/foreureka")
    public String forEureka(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
        return "hello eureka";
    }


}
