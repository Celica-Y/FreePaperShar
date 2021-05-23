package com.example.controller;

import com.example.entity.userData;
import com.example.repository.UserDataRipository;
import com.example.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class memberEntryController {
// 会員登録
    @Autowired
    UserDataRipository userDataRipository;
    @Autowired
    AccountService accountService;
    
    @RequestMapping(value="/entry", method=RequestMethod.POST)
	public ModelAndView userDataPost(@ModelAttribute("entryForm") userData userData,
    MultipartFile uploadfile, ModelAndView mv) throws Exception {
	
        /*テストデータ
            name:     寝蔵
            email:    nezou@gmail.com 
            password: nezou3
            
            name:     取り置き
            email:   torioki@yahoo.co.jp
            pass:    torioki3
         */
        
        // JSから送られたbase64形式のデータからdata~,を削除。
        String img = userData.getPicture();
        // System.out.println(img);
        String delims="[,]";
        String[] parts = img.split(delims);
        String imageString = parts[1];
        // バイト変換とデコード
        // byte[] def = imageString.getBytes();
        // System.out.println("byte変換確認：" + def);
        // byte[] bytes = Base64.getDecoder().decode(def);
        // System.out.println("デコード確認：" + bytes);

        // エンコード
        // String base64str = Base64.getEncoder().encodeToString(bytes);
        // System.out.println("エンコード確認：" + base64str);

        userData.setPicture(imageString);
        accountService.registerMember(userData, userData.getPassword());
        userDataRipository.saveAndFlush(userData);
		return new ModelAndView("redirect:/entry");
	}


   
}
