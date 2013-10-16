package biz.ezcom.spring.transaction.dao.api;

import biz.ezcom.spring.transaction.po.User;

public interface IUserDao {
    void saveMaster(User user);
    void saveSlave(User user);
}
