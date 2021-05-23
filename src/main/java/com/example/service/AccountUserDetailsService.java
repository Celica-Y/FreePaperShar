package com.example.service;

import com.example.entity.userData;
import com.example.model.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AccountUserDetailsService implements UserDetailsService{
    private final UserDao userDao;
	 
    @Autowired
      public AccountUserDetailsService(UserDao userDao) {
          this.userDao = userDao;
      }
    
    @Override
      public UserDetails loadUserByUsername(String Email)
              throws UsernameNotFoundException {          // データベースからアカウント情報を検索するメソッド

          if (Email == null || "".equals(Email)) {
              throw new UsernameNotFoundException(Email + "is not found");
          }

          // User一件を取得 userNameが無ければ例外発生
          try {
              // Userを取得
              userData myUser = userDao.findUserByUserName(Email);

              if (myUser != null) {
                  return new AccountUserDetails(myUser); // UserDetailsの実装クラスを生成

              } else {
                  throw new UsernameNotFoundException(Email + "is not found");
              }

          } catch (EmptyResultDataAccessException e) {
              throw new UsernameNotFoundException(Email + "is not found");
          }
      }
}
