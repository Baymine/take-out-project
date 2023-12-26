package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {


    /**
     * 将新注册的文件插入到数据库表中
     * @param user
     * @return
     */
    void insert(User user);

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    @Select("select * from user where id = #{userId}")
    User getById(Long userId);

    Integer countByMap(Map map);
}

