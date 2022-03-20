package com.lingnan.myschool.mapper;

import com.lingnan.myschool.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserByNameAndPassword(User user);

    List<User> getAll();

    int deleteUser(int id);

    Boolean findUserByName(@Param("name") String name);

    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);

    int addUser(User user);

    User getByName(@Param("name") String name);

    void saveUser(User user);

    void updateStatus(User user);

    void deleteAllByIds(List<Integer> id);





}
