package biz.ezcom.spring.transaction.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import biz.ezcom.spring.transaction.dao.api.IUserDao;
import biz.ezcom.spring.transaction.po.User;
import biz.ezcom.spring.transaction.service.api.IUserService;

@Service
public class UserService implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public void save(User user) {
        userDao.saveMaster(user);
        user.setUsername("Felix.Zhangxd");// 长度超出DB定义
        userDao.saveSlave(user);
    }
}
