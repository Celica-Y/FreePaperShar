package com.example.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {

    @RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView userDataPost(HttpServletResponse response, @RequestBody JsonModel jmodel,
    ModelAndView mv){
        // 地図クリックから検索。jqueryからjsonデータを受け取り、DBから検索する
        
        System.out.println(jmodel);
		return new ModelAndView("redirect:/result");
	}
    
}
