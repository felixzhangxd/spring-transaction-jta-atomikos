package biz.ezcom.spring.transaction.service.impl;

import java.sql.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.ezcom.spring.transaction.po.User;
import biz.ezcom.spring.transaction.service.api.IUserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class UserServiceTest {
    @Resource
    private IUserService userService;

    @Test
    public void testSave() {
        User user = new User(3, "Felix", "pwd", new Date(System.currentTimeMillis()));
        try{
            userService.save(user);
        }catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("ok");
    }
}
