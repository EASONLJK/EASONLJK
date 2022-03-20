package com.lingnan.myschool.Service;


import com.lingnan.myschool.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User getUserByNameAndPassword(User user);
    List<User> getAll();
    int deleteUser(int id);
    Boolean findUserByName(String name);
    int addUser(User user);
    User getByName(String name);
    User findByName(String name);
    void saveUser(User user);
    void deleteAllByIds(List<Integer> id);
}
