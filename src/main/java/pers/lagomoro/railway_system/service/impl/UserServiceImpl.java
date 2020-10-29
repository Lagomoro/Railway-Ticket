package pers.lagomoro.railway_system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import pers.lagomoro.railway_system.entity.User;
import pers.lagomoro.railway_system.mapper.UserMapper;
import pers.lagomoro.railway_system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@DS("user")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUid(Integer uid) {
        return userMapper.getUserByUid(uid);
    }

    @Override
    public User getUserByUsername(String username) { return userMapper.getUserByUsername(username); }

    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    @Override
    public int deleteByUid(Integer uid) {
        return 0;
    }

    @Override
    public int setNickname(Integer uid, String nickname) {
        return 0;
    }

    @Override
    public int setPassword(Integer uid, String password) {
        return 0;
    }

    @Override
    public int replacePassword(Integer uid, String oldPassword, String newPassword) {
        return 0;
    }

}
