package pers.lagomoro.railway_system.mapper;

import org.apache.ibatis.annotations.*;
import pers.lagomoro.railway_system.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username, password) VALUES " +
            "(#{user.username, jdbcType=VARCHAR}, #{user.password, jdbcType=VARCHAR})")
    int addUser(User user);

    @Select("select * from user where uid = #{uid, jdbcType=INTEGER}")
    User getUserByUid(Integer uid);

    @Select("select * from user where username = #{username, jdbcType=VARCHAR}")
    User getUserByUsername(String username);

    @Delete("delete from user where uid = #{uid, jdbcType=INTEGER}")
    int deleteByUid(Integer uid);

    @Update("UPDATE user SET nickname = #{nickname, jdbcType=VARCHAR} WHERE uid = #{uid, jdbcType=INTEGER}")
    int setNickname(Integer uid, String nickname);

    @Update("UPDATE user SET password = #{password, jdbcType=VARCHAR} WHERE uid = #{uid, jdbcType=INTEGER}")
    int setPassword(Integer uid, String password);

    @Update("UPDATE user SET password = REPLACE (password, #{oldPassword, jdbcType=VARCHAR}, " +
            "#{newPassword, jdbcType=VARCHAR}) WHERE uid = #{uid, jdbcType=INTEGER}")
    int replacePassword(Integer uid, String oldPassword, String newPassword);

    //====================================================================================================

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUsers();
}