package com.example.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.PaperTable;
import com.example.entity.PullDownCategory;
import com.example.entity.cityEntity;
import com.example.entity.prefectureEntity;
import com.example.repository.PaperTableRepository;
import com.example.repository.PullDownPrefectureRepository;
import com.example.repository.categoryEntityRepository;
import com.example.repository.cityEntityRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {

    @Autowired
	categoryEntityRepository categoryRepository;
	
	@Autowired 
	PullDownPrefectureRepository prefRepository;
	
	@Autowired
	cityEntityRepository cityRepository;

    @Autowired
    PaperTableRepository pRepository;
    

    @RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView referenceGet(
		@ModelAttribute PullDownCategory DownCategory,
				@ModelAttribute prefectureEntity prefEntity,
				@ModelAttribute cityEntity cityEntity, 
	 			ModelAndView mv) {
		List<prefectureEntity> pref =  prefRepository.findAll();
		mv.addObject("pref", pref);
		// 市区町村プルダウン
		List<cityEntity> city = cityRepository.findAll();
		mv.addObject("city", city);
		// System.out.println(city);

		// カテゴリープルダウン(keyは0始まり。)
		List<PullDownCategory> DC =  categoryRepository.findAll();
		mv.addObject("category", DC);
		/**
		 * 発行年プルダウン。
		 * カレンダーから今年を取得し、１０年分繰り返えしてマップにする。
		 * (keyは0始まり。)
		 */
		Calendar cl = Calendar.getInstance();

		Map<String, String> Year = new LinkedHashMap<String, String>();

		int yearData = cl.get(Calendar.YEAR);
		for (int i = 0 ; i <= 10 ; i++){
			int YearData = yearData-i ;
			Year.put(String.valueOf(i), String.valueOf(YearData));
			// System.out.println(i);
			// System.out.println(YearData);
		  }
		mv.addObject("Year", Year);

		//発行月プルダウン(keyは１始まり。)
		Map<String, String> month = new LinkedHashMap<String, String>();
		for (int i = 1; i <= 12; i++){
			month.put(String.valueOf(i), String.valueOf(i));
		}
		mv.addObject("month", month);
		
		mv.setViewName("search"); 
		return mv;
	}

     
    @RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView userDataPost(
        ModelAndView mv,
        @ModelAttribute PaperTable pTable,
        @RequestParam("PaperName") String PaperName,
        @RequestParam("prefectures") String prefectures,
        @RequestParam("city") String city,
        @RequestParam("category") String category,
        @RequestParam("year") int year,
        @RequestParam("month") int month,
        @RequestParam("comment") String comment,
        @RequestParam("Picture") String Picture,
        @RequestParam("updateDate") Date updateDate
        ){
            
            mv.addObject("category", category);
            mv.addObject("paperName", PaperName);
            mv.addObject("comment", comment);
            mv.addObject("updateDate", updateDate);
            
            
           


        /**
         * 画像データはbase64にエンコードしてhtmlに渡す
         * th:src="${base64data}"
         * th:src="${base64data-profImg}"
         */
        
            mv.setViewName("search");
            return mv;
		// return new ModelAndView("redirect/search");
	}

    
}
