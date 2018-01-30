package com.example.bootweb.service;

import com.jtl.pojo.Role;
import com.jtl.pojo.Teacher;
import org.bouncycastle.jcajce.provider.symmetric.TEA;

import java.util.List;

/**
 * Created by jiangtenglong no 2018/1/7 .
 */
public interface RoleService {

    List<Role> getRoleList();

    void insert(Role role);

    void delete(Long id);

    public Role getRole(String name);

    public Role setRole(Role role);

    public void setRoleStatus(String name,String status);

    public String getRoleStatus(String name);

    public String getRoleStatusForString(String name);

    public void setRoleStatusForString(String name,String status);

    public void addCacheList(Role role);

    public Role getCacgeList();

}
