package com.example.service;

import javax.transaction.Transactional;

import com.example.entity.userData;
import com.example.repository.UserDataRipository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountService {
    @Autowired
    UserDataRipository repository;
    @Autowired
    PasswordEncoder passwordEncoder;
 
    public void  registerMember (userData myUser,String rawPassword) {
        //		コントローラから来たパスワードをハッシュ化
                String password = passwordEncoder.encode (rawPassword);
                
        //    	ハッシュ化したパスワードをセットして保存
                myUser.setPassword(password);
                repository.saveAndFlush(myUser);
            }

    //退会
	public void deleteUserInfo(Long id) {
		
		//ユーザーに関する全情報を削除
		repository.deleteById(id);
		// repository.deleteByPaperTableId(id);

	}

}
