package pers.lcy.graduationdesign.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lcy.graduationdesign.dao.LoginTicketMapper;
import pers.lcy.graduationdesign.dao.UserMapper;
import pers.lcy.graduationdesign.model.LoginTicket;
import pers.lcy.graduationdesign.model.User;
import pers.lcy.graduationdesign.util.CommonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    @Autowired
    public LoginTicketMapper loginTicketMapper;

    public Map<String,Object> register(String username,String password){
        Map<String, Object> resMsg = new HashMap<String, Object>();
        if (StringUtils.isEmpty(username)) {
            resMsg.put("msgname", "用户名不得为空");
            return resMsg;
        }
        if (StringUtils.isBlank(password)) {
            resMsg.put("msgpassword", "密码不得为空");
            return resMsg;
        }
        if (userMapper.selectUserByname(username) != null) {
            resMsg.put("msgname", "用户名重复!!!");
            return resMsg;
        }
        User newUser=new User();
        newUser.setUsername(username);
        newUser.setSalt(UUID.randomUUID().toString().substring(0,5));
        newUser.setPassword(CommonUtil.MD5(password + newUser.getSalt()));
        newUser.setRole(1);
        userMapper.addUser(newUser);
        String ticket=addLoginTicket(userMapper.selectUserIdByName(username));
        resMsg.put("ticket",ticket);
        return resMsg;
    }
    public Map<String,Object> login(String username,String password){
        Map<String, Object> resMsg = new HashMap<String, Object>();
        if (StringUtils.isBlank(username)) {
            resMsg.put("msgname", "用户名不得为空");
            return resMsg;
        }
        if (StringUtils.isBlank(password)) {
            resMsg.put("msgpassword", "密码不得为空");
            return resMsg;
        }
        User user=userMapper.selectUserByname(username);
        if (user == null) {
            resMsg.put("msgname", "用户名不存在");
            return resMsg;
        }
        if(!CommonUtil.MD5(password+user.getSalt()).equals(user.getPassword())){
            resMsg.put("msgpwd","密码不正确");
        }
        String ticket=addLoginTicket(user.getId());
        resMsg.put("ticket",ticket);
        return resMsg;
    }
    private String addLoginTicket(int userId){
        LoginTicket ticket=new LoginTicket();
        ticket.setUserId(userId);
        Date date=new Date();
        date.setTime(date.getTime()+1000*3600*24);
        ticket.setExpiredTime(date);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        ticket.setState(0);
        loginTicketMapper.insertTicket(ticket);
        return ticket.getTicket();
    }
}
