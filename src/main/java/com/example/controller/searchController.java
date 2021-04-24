package com.example.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import com.example.entity.PaperTable;
import com.example.model.JsonModel;
import com.example.repository.PaperTableRepository;
import com.example.service.paperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("paperService.class")
@Controller
public class searchController {

    @Autowired
    paperService pService;
    @Autowired
    PaperTableRepository pRepository;
     
    @RequestMapping(value="/search", method=RequestMethod.POST)
    @ResponseBody
	public ModelAndView userDataPost(
        @RequestBody JsonModel jmodel,
        @ModelAttribute
        // @RequestParam("prefectures") String prefectures,
        // @RequestParam("city") String city,
        // @RequestParam("category") String category,
        // @RequestParam("year") int year,
        // @RequestParam("month") int month,
        ModelAndView mv){
        /** 地図クリックから検索。
         *  jqueryからjsonデータを受け取り、
         *  DB検索：Codeとpaper_tableのprefectures_nameが一致する物を探す
         */ 
        // List<PaperTable> paper = pRepository.findAll();
        // mv.addObject("result", paper);

        System.out.println("ajaxから：" + jmodel.getName());
        List<PaperTable> List = pService.search(jmodel.getName());
        // mv.addObject("result", List);

        // System.out.println(List);
        
        // mv.setViewName("/post");
        return mv;
		// return new ModelAndView("redirect/result");
	}

    
}
