package com.lingnan.myschool.ServiceImpl;

import com.lingnan.myschool.Service.AdminRoleService;
import com.lingnan.myschool.Service.UserService;
import com.lingnan.myschool.mapper.StudentMapper;
import com.lingnan.myschool.mapper.UserMapper;
import com.lingnan.myschool.pojo.AdminRole;
import com.lingnan.myschool.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminRoleService adminRoleService;

    @Override
    public User getUserByNameAndPassword(User user) {
        User user1 = userMapper.getUserByNameAndPassword(user);
        return user1;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userMapper.getAll();
        List<AdminRole> adminRoles;
        for (User user : users) {
             adminRoles = adminRoleService.listRoleByName(user.getName());
            user.setRoles(adminRoles);

        }

        return users;
    }

    @Override
    public int deleteUser(int id) {
        int i = userMapper.deleteUser(id);
        return i;
    }

    @Override
    public Boolean findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void deleteAllByIds(List<Integer> id) {
        userMapper.deleteAllByIds(id);
    }
}
