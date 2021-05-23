package com.example.model;

import com.example.entity.userData;

public interface UserDao {
    userData findUserByUserName(String Email);
}
