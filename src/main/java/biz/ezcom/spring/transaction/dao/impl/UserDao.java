package biz.ezcom.spring.transaction.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import biz.ezcom.spring.transaction.dao.api.IUserDao;
import biz.ezcom.spring.transaction.po.User;

@Repository
public class UserDao implements IUserDao {
    @Resource
    private JdbcTemplate jdbcTemplateMaster;
    @Resource
    private JdbcTemplate jdbcTemplateSlave;

    @Override
    public void saveMaster(final User user) {
        final String sql = "INSERT INTO user (username, password, birthday) VALUES(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplateMaster.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setDate(3, user.getBirthday());
                return ps;
            }
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        user.setId(id);
    }

    @Override
    public void saveSlave(final User user) {
        final String sql = "INSERT INTO user (username, password, birthday) VALUES(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplateSlave.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setDate(3, user.getBirthday());
                return ps;
            }
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        user.setId(id);
    }
}
