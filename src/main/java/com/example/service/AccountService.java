package com.example.service;

import com.example.entity.userData;
import com.example.repository.UserDataRipository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    UserDataRipository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
 
    public void  registerMember (userData user,String rawPassword) {
//		コントローラから来たパスワードをハッシュ化
    	String password = passwordEncoder.encode (rawPassword);
    	
//    	ハッシュ化したパスワードをセットして保存
    	user.setPassword(password);
        userRepository.saveAndFlush(user);
    }
}
