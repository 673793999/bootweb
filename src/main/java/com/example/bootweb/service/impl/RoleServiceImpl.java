package com.example.bootweb.service.impl;

import com.example.bootweb.mapper.RoleMapper;
import com.example.bootweb.service.RoleService;
import com.jtl.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiangtenglong no 2018/1/7 .
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RoleMapper roleMapper;


    @Override
    public List<Role> getRoleList() {
        return roleMapper.getAll();
    }

    @Override
    public void insert(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void delete(Long id) {
        roleMapper.delete(id);
    }


    public Role getRole(String name){
        return (Role)redisTemplate.opsForValue().get(name);
    }

    @Override
    public Role setRole(Role role) {
        redisTemplate.opsForValue().set(role.getRoleName(),role);
        return role;
    }

    @Override
    public void setRoleStatus(String name, String status) {
        redisTemplate.opsForValue().set(name,status);
    }

    @Override
    public String getRoleStatus(String name) {
        return (String)redisTemplate.opsForValue().get(name);
    }

    @Override
    public String getRoleStatusForString(String name) {
        return stringRedisTemplate.opsForValue().get(name);
    }

    @Override
    public void setRoleStatusForString(String name, String status) {
        stringRedisTemplate.opsForValue().set(name,status);
    }

    @Override
    public void addCacheList(Role role) {
        redisTemplate.opsForList().leftPush("roleList",role);
    }

    @Override
    public Role getCacgeList() {
        return (Role)redisTemplate.opsForList().rightPop("roleList");
    }


}
