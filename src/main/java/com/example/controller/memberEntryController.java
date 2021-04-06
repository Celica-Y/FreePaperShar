package com.example.controller;

import java.util.Base64;

import com.example.entity.userData;
import com.example.ripository.UserDataRipository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class memberEntryController {

    @Autowired
    UserDataRipository userDataRipository;
    
    @RequestMapping(value="/entry", method=RequestMethod.POST)
	public ModelAndView userDataPost(@ModelAttribute("entryForm") userData userData,
    ModelAndView mv) {

        // エンコード
        String profilePicture =userData.getProfilePicture();
        String encoded = Base64.getEncoder().encodeToString(profilePicture.getBytes());
        userData.setProfilePicture(encoded);


        userDataRipository.saveAndFlush(userData);
		return new ModelAndView("redirect:/mypage");
	}
}
