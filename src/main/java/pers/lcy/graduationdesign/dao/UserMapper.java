package pers.lcy.graduationdesign.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import pers.lcy.graduationdesign.model.User;

@Mapper
@Component
public interface UserMapper {
    User selectUserByname(@Param("name") String name );

    void addUser(User user);

    int selectUserIdByName(@Param("name") String name);

    User selectUserById(@Param("id")int id);
}