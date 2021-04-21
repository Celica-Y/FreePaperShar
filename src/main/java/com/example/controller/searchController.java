package com.example.controller;

import java.util.List;

import com.example.entity.PaperTable;
import com.example.model.JsonModel;
import com.example.ripository.PaperTableRipository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {
    
    // @Autowired 
    // PaperTableRipository ptRipository;
     
    @RequestMapping(value="/search", method=RequestMethod.POST)
    @ResponseBody
	public ModelAndView userDataPost(
        // @ModelAttribute PaperTable paperTable,
        @RequestBody JsonModel jmodel,
        ModelAndView mv){
        /** 地図クリックから検索。
         *  jqueryからjsonデータを受け取り、
         *  DB検索：Codeとpaper_tableのprefectures_nameが一致する物を探す
         */ 
        
        // List<PaperTable> paper = ptRipository.findByPaperName(jmodel.getName());
        // System.out.println(paper);
        System.out.println(jmodel.getName());
		return new ModelAndView("redirect:/result");
	}
    
}
