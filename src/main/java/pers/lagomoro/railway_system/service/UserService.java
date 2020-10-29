package pers.lagomoro.railway_system.service;

import pers.lagomoro.railway_system.entity.User;

public interface UserService {

    User getUserByUid(Integer uid);

    User getUserByUsername(String username);

    int addUser(User user);

    int deleteByUid(Integer uid);

    int setNickname(Integer uid, String nickname);

    int setPassword(Integer uid, String password);

    int replacePassword(Integer uid, String oldPassword, String newPassword);

}
