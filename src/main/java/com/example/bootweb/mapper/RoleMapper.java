package com.example.bootweb.mapper;

import com.jtl.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jiangtenglong no 2018/1/8 .
 */
@Mapper
public interface RoleMapper {

    @Update("UPDATE role SET role_name=#{roleName},role_code=#{roleCode} WHERE id =#{id}")
    void update(Role role);

    @Insert("INSERT INTO role(role_name,role_code,create_time) VALUES(#{roleName}, #{roleCode},sysdate())")
    void insert(Role role);

    @Delete("DELETE FROM role WHERE id =#{id}")
    void delete(Long id);

    @Select("select * from role")
    @Results({
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleCode",column = "role_code"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "updateTime",column = "update_time"),
            @Result(property = "deleteTime",column = "delete_time"),
    })
    List<Role> getAll();


}
