package pers.lcy.graduationdesign;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.*;
import pers.lcy.graduationdesign.dao.UserMapper;
import pers.lcy.graduationdesign.model.User;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class GraduationdesignApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user=new User();
        user.setUsername("a");
        user.setPassword("123");
        user.setSalt("000");
        user.setRole(0);
        userMapper.addUser(user);
    }

}
