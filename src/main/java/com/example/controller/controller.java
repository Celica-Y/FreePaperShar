package com.example.controller;
 
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.PullDownCategory;
import com.example.entity.cityEntity;
import com.example.entity.prefectureEntity;
import com.example.ripository.PullDownPrefectureRipository;
import com.example.ripository.categoryEntityRipository;
import com.example.ripository.cityEntityRipository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {
	@Autowired
	categoryEntityRipository categoryRipository;
	
	@Autowired 
	PullDownPrefectureRipository prefRipository;
	
	@Autowired
	cityEntityRipository cityRipository;
	
// indexページの表示
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv) {
		mv.setViewName("index"); 
		return mv;
	}

// entryページの表示
	@RequestMapping(value="/entry", method=RequestMethod.GET)
	public ModelAndView entryGet(ModelAndView mv) {
		mv.setViewName("entry"); 
		return mv;
	}

// ログインページの表示
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("login"); 
		return mv;
	}

// 検索ページの表示
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView referenceGet(
		@ModelAttribute PullDownCategory DownCategory,
		@ModelAttribute prefectureEntity prefEntity,
		@ModelAttribute cityEntity cityEntity, 
		ModelAndView mv) {

			List<prefectureEntity> pref =  prefRipository.findAll();
		mv.addObject("pref", pref);
		// 市区町村プルダウン
		List<cityEntity> city = cityRipository.findAll();
		mv.addObject("city", city);
		// System.out.println(city);

		// カテゴリープルダウン(keyは0始まり。)
		List<PullDownCategory> DC =  categoryRipository.findAll();
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

// 投稿ページの表示(urlはログイン機能追加後に変更)
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public ModelAndView registerGet(
				@ModelAttribute PullDownCategory DownCategory,
				@ModelAttribute prefectureEntity prefEntity,
				@ModelAttribute cityEntity cityEntity, 
	 			ModelAndView mv) {
		List<prefectureEntity> pref =  prefRipository.findAll();
		mv.addObject("pref", pref);
		// 市区町村プルダウン
		List<cityEntity> city = cityRipository.findAll();
		mv.addObject("city", city);
		// System.out.println(city);

		// カテゴリープルダウン(keyは0始まり。)
		List<PullDownCategory> DC =  categoryRipository.findAll();
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


		mv.setViewName("register"); 
		return mv;
	}

// 投稿詳細ぺーじの表示
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView datailsGet(ModelAndView mv) {
		mv.setViewName("details"); 
		return mv;
	}

// マイページの表示
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public ModelAndView mypageGet(ModelAndView mv) {
		mv.setViewName("mypage"); 
		return mv;
	}

// 検索結果一覧表示
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public ModelAndView searchResultGet(ModelAndView mv) {
		mv.setViewName("searchResult"); 
		return mv;
	}

// 投稿一覧の表示
	@RequestMapping(value="/post", method=RequestMethod.GET)
	public ModelAndView postListGet(ModelAndView mv) {
		mv.setViewName("postList"); 
		return mv;
	}

// お気に入り一覧の表示
	@RequestMapping(value="/favorite", method=RequestMethod.GET)
	public ModelAndView favoriteListGet(ModelAndView mv) {
		mv.setViewName("favoriteList"); 
		return mv;
	}

// 退会ページの表示
	@RequestMapping(value="/withd", method=RequestMethod.GET)
	public ModelAndView withdrawalGet(ModelAndView mv) {
	mv.setViewName("withdrawal"); 
	return mv;
	}

// プロフ変更ページ表示
	@RequestMapping(value="/change", method=RequestMethod.GET)
	public ModelAndView profilleChangeGet(ModelAndView mv) {
	mv.setViewName("profilleChange"); 
	return mv;
	}
}