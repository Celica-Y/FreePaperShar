package com.example.controller;

import com.example.entity.PaperTable;
import com.example.ripository.PaperTableRipository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaperTableController {
    @Autowired
    PaperTableRipository PaperRipository;
    
    @RequestMapping(value="/regist", method=RequestMethod.POST)
	public ModelAndView PaperTablePost(@ModelAttribute("PaperForm") PaperTable paperTable, ModelAndView mv) {
        PaperRipository.saveAndFlush(paperTable);
		return new ModelAndView("redirect:/mypage");
	}
}