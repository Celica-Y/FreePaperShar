package com.example.model;

import java.util.Map;

import com.example.entity.userData;

import org.dom4j.util.UserDataAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   
    @Override
    public userData findUserByUserName(String Email) {
        String sql = "SELECT user_name, email, password FROM user_table WHERE email = ?";

        //ユーザを一件取得
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, Email);

        // Entityクラス(User型)に変換
        userData user = convMapToUser(result);

        return user;
    }

   
    private userData convMapToUser(Map<String, Object> map) {
        userData user = new userData();

        user.setUserName((String) map.get("user_name"));
        user.setPassword((String) map.get("password"));
        user.setEmail((String) map.get("Email"));
        

        return user;
    }
}
