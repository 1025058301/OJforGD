package pers.lcy.graduationdesign.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.lcy.graduationdesign.service.UserService;
import pers.lcy.graduationdesign.util.CommonUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {
    public static Logger logger= LoggerFactory.getLogger(LoginController.class);
    public static final String TICKET="ticket";

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/reg",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam(value="rember",defaultValue ="0") int rememberme,
                           HttpServletResponse response){
        Map<String,Object> result=userService.register(username,password);
        if(result.containsKey(TICKET)){
            Cookie cookie=new Cookie("ticket",result.get("ticket").toString());
            cookie.setPath("/");
            if(rememberme>0){
                cookie.setMaxAge(3600*24*2);
            }
            response.addCookie(cookie);
            logger.info("注册成功");
            return CommonUtil.getJsonString(0,"注册成功");
        }
        logger.info("注册失败");
        return CommonUtil.getJsonString(1,result);

    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET} )
    @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value="rember",defaultValue ="0") int rememberme,
                        HttpServletResponse response){
        Map<String,Object> result=userService.login(username,password);
        if(result.containsKey(TICKET)){
            Cookie cookie=new Cookie("ticket",result.get("ticket").toString());
            cookie.setPath("/");
            if(rememberme>0){
                cookie.setMaxAge(3600*24*2);
            }
            response.addCookie(cookie);
            logger.info("登录成功");
            return CommonUtil.getJsonString(0,"登录成功");
        }
        logger.info("登录失败");
        return CommonUtil.getJsonString(1,result);
    }
}
