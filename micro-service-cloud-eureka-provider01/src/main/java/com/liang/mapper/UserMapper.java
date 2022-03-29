package com.liang.mapper;

import com.liang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from tb_user")
    List<User> findUsers();

    @Select("select * from tb_user where id=#{id}")
    User findUserById(Integer id);
}
