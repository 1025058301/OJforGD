package pers.lcy.graduationdesign.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import pers.lcy.graduationdesign.model.LoginTicket;
@Mapper
@Component
public interface LoginTicketMapper {
    void insertTicket(LoginTicket loginTicket);

    LoginTicket selectByTicket(@Param("ticket") String ticket);
}