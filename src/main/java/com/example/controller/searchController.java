package com.example.controller;

import java.util.List;

import com.example.entity.PaperTable;
import com.example.model.JsonModel;
import com.example.repository.PaperTableRepository;
import com.example.service.paperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {
    
    @Autowired 
    PaperTableRepository ptRepository;

    @Autowired
    paperService pService;
     
    @RequestMapping(value="/search", method=RequestMethod.POST)
    @ResponseBody
	public ModelAndView userDataPost(
        @ModelAttribute("SearchForm") PaperTable paper,
        @ModelAttribute PaperTable paperTable,
        @RequestBody JsonModel jmodel,
        @RequestParam()
        ModelAndView mv){
        /** 地図クリックから検索。
         *  jqueryからjsonデータを受け取り、
         *  DB検索：Codeとpaper_tableのprefectures_nameが一致する物を探す
         */ 
        String pref = paper.getPicture();
        List<PaperTable> p = ptRepository.findByPrefectures(pref);
        System.out.println(p);
        // System.out.println("ajaxから：" + jmodel.getCode());

        
		return new ModelAndView("redirect:/result");
	}
    
}
