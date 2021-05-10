package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.entity.PaperTable;
import com.example.repository.PaperTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {

    @Autowired
    PaperTableRepository pRepository;
     
    @RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView userDataPost(
        // @ModelAttribute ("SearchForm") PaperTable table,
        // @RequestParam("prefectures") String prf,
        // @RequestParam("city") String city,
        // @RequestParam("category") String category,
        // @RequestParam("year") int year,
        // @RequestParam("month") int month,
        ModelAndView mv){
        
        // List<PaperTable> paper = pRepository.findAll();
        // mv.addObject("result", paper);
        // System.out.println(paper);

        
        mv.setViewName("search");
        return mv;
		// return new ModelAndView("redirect/search");
	}

    
}
